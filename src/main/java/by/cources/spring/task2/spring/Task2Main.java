package by.cources.spring.task2.spring;

import by.cources.spring.task2.spring.model.Author;
import by.cources.spring.task2.spring.model.Book;
import by.cources.spring.task2.spring.repository.AuthorRepository;
import by.cources.spring.task2.spring.repository.BookRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task2Main {

  public static void main(String[] args) throws ParseException {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
//    BookRepository service = ctx.getBean(BookRepository.class);
//    List<Book> all = service.findAll();
//    for (Book book : all) {
//      System.out.println("All books " + book);
//    }

    AuthorRepository repo = ctx.getBean(AuthorRepository.class);
    List<Author> author = repo.findAllAuthor();
    for (Author aut : author) {
      System.out.println("All books " + aut);
    }
    long id = 4L;
    String sourceDate = "1900-01-01";
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sourceDate);
    List<Author> allPublished = repo.findAllPublished(date);
    System.out.println("Book with id = " + id + " is " + allPublished);
  }
}
