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
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book changeBook(Book book) {
        Book bookUpdate = bookRepository.findById(book.getId()).get();
        //логика апдейта должна прописываться здесь
        //здесь дополнительно айди не стоит передавать в параметрах, я его удалила
        //сделай плз проверку на нул здесь и в гетБайАйди, если его ловит то сообщение типа "такого айди не существует",
        //и это сообщение нужно в модельке возвращать, а не просто строкой и на уровне контролера его засунуть в респонсэнтити
        return bookRepository.save(bookUpdate);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Boolean isBookExist(Long id) {
        if(bookRepository.findBookById(id) != null) return true;
        return false;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }
    @Override
    public List<Book> getBooksByName(String name) {
        return bookRepository.findBooksByName(name);
    }

    @Override
    public Message changeBook2(Book book) {
        Message msg=new Message("Book has been changed");
        if(!(isBookExist(book.getId()))){
            msg.setMessage("Not found");
            return msg;
        }
        return msg;
    }
}
