package by.cources.spring.task6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class BookWebConfig implements WebMvcConfigurer {

  private final BookJpaConfig jpaConfig;

  public BookWebConfig(BookJpaConfig jpaConfig) {
    this.jpaConfig = jpaConfig;
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Bean
  public ResourceBundleMessageSource resourceBundleMessageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("messages");
    return messageSource;
  }

  @Bean
  public InternalResourceViewResolver jspViewResolver() {
    InternalResourceViewResolver bean = new InternalResourceViewResolver();
    bean.setPrefix("/WEB-INF/views/");
    bean.setSuffix(".jsp");
    bean.setOrder(1);
    return bean;
  }

  @Bean
  public InternalResourceViewResolver htmlViewResolver() {
    InternalResourceViewResolver bean = new InternalResourceViewResolver();
    bean.setPrefix("/WEB-INF/html/");
    bean.setSuffix(".html");
    bean.setOrder(2);
    return bean;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    OpenEntityManagerInViewInterceptor interceptor = new OpenEntityManagerInViewInterceptor();
    interceptor.setEntityManagerFactory(jpaConfig.entityManagerFactory().getObject());
    registry.addWebRequestInterceptor(interceptor);
  }
}
