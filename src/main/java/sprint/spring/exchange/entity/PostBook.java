package sprint.spring.exchange.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "z_post")
public class PostBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private String login;
    private String terms;
    private LocalDateTime datePosted;

    public PostBook() {
    }

    public PostBook(Category category, Book book, String login, String terms) {
        this.category = category;
        this.book = book;
        this.login = login;
        this.terms = terms;
        this.datePosted = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }
}
