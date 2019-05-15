package sprint.spring.exchange.model;

import sprint.spring.exchange.entity.Book;

public class PostBookModel {
    private Book book;
    private String terms;

    public PostBookModel(Book book, String terms) {
        this.book = book;
        this.terms = terms;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }
}
