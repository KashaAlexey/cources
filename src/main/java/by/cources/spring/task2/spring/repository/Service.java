package by.cources.spring.task2.spring.repository;

import by.cources.spring.task2.spring.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {

    @Autowired
    private AuthorRepository repository;

   @Autowired
    private BookRepository repositoryBook;

    public Service(AuthorRepository repository) {
        this.repository = repository;
    }

    public Service(BookRepository repository) {
        this.repositoryBook = repository;
    }

    public List<Author> findAll() {
        return repository.findAllAuthor();
    }
}
