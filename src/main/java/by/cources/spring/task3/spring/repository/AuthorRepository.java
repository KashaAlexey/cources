package by.cources.spring.task3.spring.repository;

import by.cources.spring.task3.spring.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository {

  List<Author> findWithBookOlderThan(Long value);

  Optional<Author> findById(Long id);

  List<Author> findAll();

  List<Author> findAuthorByLang(String value);

  List<Author> findAuthorByLangByDate(String value, Long year);
}
