package sprint.spring.exchange.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "z_journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "giv_login")
    private String login;
    private LocalDateTime datePosted;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "rec_login")
    private String recLogin;
    private LocalDateTime dateBooked;

    public Journal() {
    }

    public Journal(PostBook postBook, String recLogin){
        this.category = postBook.getCategory();
        this.login = postBook.getLogin();
        this.datePosted = postBook.getDatePosted();
        this.book = postBook.getBook();
        this.recLogin = recLogin;
        this.dateBooked = LocalDateTime.now();
    }

    public Journal(Category category, String login, LocalDateTime datePosted, Book book, String recLogin) {
        this.category = category;
        this.login = login;
        this.datePosted = datePosted;
        this.book = book;
        this.recLogin = recLogin;
        this.dateBooked = LocalDateTime.now();
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getRecLogin() {
        return recLogin;
    }

    public void setRecLogin(String recLogin) {
        this.recLogin = recLogin;
    }

    public LocalDateTime getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(LocalDateTime dateBooked) {
        this.dateBooked = dateBooked;
    }
}
