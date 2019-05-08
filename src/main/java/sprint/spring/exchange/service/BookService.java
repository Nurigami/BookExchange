package sprint.spring.exchange.service;

import sprint.spring.exchange.entity.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    void removeBook(Long id);

    Book changeBook(Book book, Long id);

    List<Book> getAllBooks();

    Book getBookById(Long id);
}
