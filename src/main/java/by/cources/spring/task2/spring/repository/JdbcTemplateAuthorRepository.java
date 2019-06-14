package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.repository.mapping.AuthorMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

public class JdbcTemplateAuthorRepository implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateAuthorRepository(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Author> findAllAuthor() {
        return jdbcTemplate.query("select * from author ", new AuthorMapper());
    }

    @Override
    public List<Author> findAllPublished(Date date) {
        return jdbcTemplate.query("select a.* from author as a  left join book as b  on (a.id = b.author_id) where b.published > ?", new Object[]{date}, new AuthorMapper());
    }

    @Override
    public Author findAuthor(Long id) {
        return jdbcTemplate.queryForObject("select * from book where id = ?", new Object[]{id}, new AuthorMapper());
    }

}
