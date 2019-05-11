package sprint.spring.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.spring.exchange.entity.Book;
import sprint.spring.exchange.model.Message;
import sprint.spring.exchange.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Message addBook(Book book) {
        bookRepository.save(book);
        return new Message("Book was saved.");
    }

    @Override
    public Book getBookById(Long id) {
        for(Book b : bookRepository.findAll()){
            if(b.getId().equals(id)){
                return b;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Message updateBook(Book book) {
        for(Book b : bookRepository.findAll()){
            if(b.getId().equals(book.getId())){
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
                b.setDescription(book.getDescription());
                bookRepository.save(b);
                return new Message("Book is updated");
            }
        }
        return new Message("Book with id " + book.getId()+ " does not exist");
    }

    @Override
    public List<Book> getBooksByNameAndAuthor(String name, String author) {
        return bookRepository.findBooksByNameAndAuthor(name, author);
    }
    @Override
    public Message deleteBook(Long id) {
        for(Book b : bookRepository.findAll()){
            if(b.getId().equals(id)){
                bookRepository.delete(b);
                return new Message("Book is removed");
            }
        }
        return new Message("Book with id " + id + " does not exist");
    }


}
