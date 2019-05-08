package sprint.spring.exchange.model;

public class Ranking {
    private String login;
    private Long count;

    public Ranking() {
    }

    public Ranking(String login, Long count) {
        this.login = login;
        this.count = count;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
