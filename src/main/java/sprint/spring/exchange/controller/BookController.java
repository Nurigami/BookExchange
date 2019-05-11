package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.service.BookService;


import java.util.List;

@RestController
@RequestMapping("/exchange/book")
public class BookController {
    @Autowired
    private BookService bookService;
    //лишние пути я убрала, так неудобно будет самим ориентироваться
    //оберни плз все ответы в респонсэнтити, в эддбук в респонсэтити еще локейшн нужно создать
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.removeBook(id);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        Book currentBook = bookService.changeBook(book);
        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    @GetMapping("/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }
    @GetMapping("/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }
}
