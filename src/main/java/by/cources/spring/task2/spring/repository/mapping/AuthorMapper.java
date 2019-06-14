package by.cources.spring.task2.spring.repository.mapping;

import by.cources.spring.task2.spring.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {

    public Author mapRow(ResultSet resultSet, int i) throws SQLException {

        Author author = new Author();
        author.setId(resultSet.getLong("id"));
        author.setName(resultSet.getString("name"));
        author.setDateOfBirth(resultSet.getDate("date_of_birth"));
        return author;
    }
}
