package sprint.spring.exchange.model;

public class JsonMsg {
    private String message;
    private String login;

    public JsonMsg() {
    }

    public JsonMsg(String message) {
        this.message = message;
    }

    public JsonMsg(String message, String login) {
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
