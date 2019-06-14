package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;

import java.util.Date;
import java.util.List;

public interface AuthorRepository {

    List<Author> findAllAuthor();
    List<Author> findAllPublished(Date datePublised);

    Author findAuthor(Long id);
}
