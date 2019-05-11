package sprint.spring.exchange.model;

public class RecMessage {
    private String message;
    private String login;

    public RecMessage(String message, String login) {
        this.message = message;
        this.login = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
