package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.model.Message;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    void removeBook(Long id);

    Book changeBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Message changeBook2(Book book);

    Boolean isBookExist(Long id);

    List <Book> getBooksByName(String name);

    List<Book>getBooksByAuthor(String author);
}
