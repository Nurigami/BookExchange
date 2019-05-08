package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.service.BookService;


import java.util.List;

@RestController
@RequestMapping(name = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/removeBook/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.removeBook(id);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable Long id) {
        Book currentBook = bookService.changeBook(book, id);
        currentBook.setName(book.getName());
        currentBook.setDescription(book.getDescription());
        currentBook.setAuthor(book.getAuthor());
        currentBook.setCategory(book.getCategory());
        currentBook.setUser(book.getUser());
        currentBook.setBooked(book.getBooked());
        bookService.changeBook(currentBook, id);
        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
    }

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

}
