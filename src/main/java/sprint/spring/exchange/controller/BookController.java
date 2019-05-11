package sprint.spring.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.service.BookService;


import java.util.List;

@RestController
@RequestMapping("/exchange/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Message> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Message> updateBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
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
