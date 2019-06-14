package by.cources.spring.task3.spring;

import by.cources.spring.task3.spring.model.Author;
import by.cources.spring.task3.spring.model.Book;
import by.cources.spring.task3.spring.service.BookService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task3Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BookConfig.class);
    BookService service = ctx.getBean(BookService.class);
    System.out.println("---------------------");
    query1(service);
    System.out.println("---------------------");
    query2(service);
    System.out.println("---------------------");
    query3(service);
  }

  private static void query1(BookService service) {
    List<Book> all = service.findBooksByLang("English");
    for (Book book : all) {
      System.out.println("Query1: " + book);
    }
  }

  private static void query2(BookService service) {
    List<Author> all = service.findAuthorByLang("English");
    for (Author author : all) {
      System.out.println("Query2: " + author);
    }
  }

  private static void query3(BookService service) {
    List<Author> all = service.findAuthorByLangByDate("Spain", 1800L);
    for (Author author : all) {
      System.out.println("Query3: " + author);
    }
  }

}
