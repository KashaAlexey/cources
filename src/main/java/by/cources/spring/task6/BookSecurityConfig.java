package by.cources.spring.task6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
public class BookSecurityConfig extends WebSecurityConfigurerAdapter {

  private final BookJpaConfig jpaConfig;

  public BookSecurityConfig(BookJpaConfig jpaConfig) {
    this.jpaConfig = jpaConfig;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    jdbcAuthentication(auth);
//    inMemoryAuthentication(auth);
  }

  private void inMemoryAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .passwordEncoder(passwordEncoder())
        .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("123456")).roles("USER", "ADMIN");
  }

  private void jdbcAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(jpaConfig.dataSource())
        .withDefaultSchema()
        .passwordEncoder(passwordEncoder())
        .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("123456")).roles("USER", "ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/book/edit/**").hasAnyRole("ADMIN", "USER")
        //.antMatchers("/book/**").hasRole("USER")
        .antMatchers("/book/delete/**").hasRole("ADMIN")
        .antMatchers("/book/update/**").hasRole("ADMIN")
        .antMatchers("/book/list").hasAnyRole("ADMIN","USER")
        .antMatchers("/book/index").hasAnyRole("ADMIN","USER")
        .antMatchers("/**").hasRole("ADMIN")
        .and().formLogin().defaultSuccessUrl("/book/index", true)
        //.and().formLogin().successForwardUrl("sp-cources/book/list")
        //.and().formLogin().loginProcessingUrl("/book/list")
        .and().logout().logoutSuccessUrl("/login").permitAll()
        .and().csrf().disable();
  }
}
