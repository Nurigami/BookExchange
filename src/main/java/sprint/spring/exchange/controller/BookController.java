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

    @PostMapping("/user")
    public ResponseEntity<Message> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<Message> updateBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.OK);
    }

    @GetMapping("/all/search")
    public ResponseEntity <List<Book>> getBooksByNameAndAuthor(@RequestHeader(required = false) String name,
                                                               @RequestHeader (required = false) String author) {

        return new ResponseEntity< >(bookService.getBooksByNameAndAuthor(name,author),HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Message> deleteBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
    }

}
