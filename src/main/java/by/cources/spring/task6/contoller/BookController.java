package by.cources.spring.task6.contoller;

import by.cources.spring.task6.model.Author;
import by.cources.spring.task6.model.Book;
import by.cources.spring.task6.service.BookService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {

  public static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public ModelAndView form() {
    Book result = new Book();
    result.setPublishedIn(2019L);
    result.setAuthor(new Author());
    return new ModelAndView("book-form", "book", result);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public String submit(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
      for (ObjectError error : result.getAllErrors()) {
        LOGGER.error(error.toString());
      }
      model.addAttribute("errorMessage", "something wrong");
//      return "error";
      return "book-form";
    }
    bookService.saveBook(book);
    return "redirect:list";
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView list() {
    List<Book> booksAll = bookService.findBooksAll();
//    return new ModelAndView("books", "booksVariable", booksAll);
    Map<String, Object> model = new HashMap<>();
    model.put("booksVariable", booksAll);
    return new ModelAndView("books", model);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public ModelAndView delete(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
    ModelAndView modelAndView = new ModelAndView("redirect:/book/list");
    bookService.delete(book);
    return modelAndView;
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public ModelAndView deleteById(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView("book-delete");
    modelAndView.addObject("book", bookService.getBookById(id));
    return modelAndView;
  }
}