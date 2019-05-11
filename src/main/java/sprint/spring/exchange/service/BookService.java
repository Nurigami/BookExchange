package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.model.Message;

import java.util.List;

public interface BookService {
    Message addBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Message updateBook(Book book);
    Message deleteBook(Long id);
    List<Book>getBooksByNameAndAuthor(String name,String author);

}
