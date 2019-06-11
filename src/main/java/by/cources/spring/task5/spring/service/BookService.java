package by.cources.spring.task5.spring.service;

import by.cources.spring.task5.spring.model.Author;
import by.cources.spring.task5.spring.model.Book;
import by.cources.spring.task5.spring.model.Language;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

public interface BookService {

  List<Book> findBooksAll();

  @Transactional
  Author saveAuthor(Author author);

  List<Author> findAuthorsWithBookOlderThan(Long value);

  List<Book> findBooksWithBookOlderThan(Long value);

  List<Book> findBooksWithBookName(String value);

  List<Author> findAuthorsAll();

  List<Language> findLanguagesAll();

  Book saveBook(Book book);

  void deleteBook(Long id);

  Optional<Book> findBookById(Long id);
}
