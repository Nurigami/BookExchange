package sprint.spring.exchange.entity;

import javax.persistence.*;

@Entity
@Table(name = "z_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String name;
    private String description;
    private String author;
    private String terms;
    private String login;
    private Boolean isBooked;

    public Book() {
    }

    public Book(String name, String description, String author, String terms, String login, Boolean isBooked) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.terms = terms;
        this.login = login;
        this.isBooked = isBooked;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }
}
