package sprint.spring.exchange.model;

public class PostModel {
    private Long categoryId;
    private Long bookId;
    private String terms;

    public PostModel(Long categoryId, Long bookId, String terms) {
        this.categoryId = categoryId;
        this.bookId = bookId;
        this.terms = terms;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

}
