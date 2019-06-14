package by.cources.spring.task3.spring.service;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.repository.AuthorRepository;
import by.cources.spring.task3.spring.repository.BookRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import by.cources.spring.task3.spring.repository.LanguageRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final LanguageRepository languageRepository;

  public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, LanguageRepository languageRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.languageRepository = languageRepository;
  }

  @Transactional
  @Override
  public List<Book> findBooksByLang(String value) {
    return bookRepository.findBooksByLang(value);
  }

  @Override
  @Transactional
  public List<Author> findAuthorByLang(String value) {
    return authorRepository.findAuthorByLang(value);
  }

  @Override
  @Transactional
  public List<Author> findAuthorByLangByDate(String value, Long year) {
    return authorRepository.findAuthorByLangByDate(value, year);
  }

  private <T> List<T> toList(Iterable<T> result) {
    return StreamSupport
        .stream(result.spliterator(), false)
        .collect(Collectors.toList());
  }
}
