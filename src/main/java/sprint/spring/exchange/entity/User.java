package sprint.spring.exchange.entity;

import javax.persistence.*;

@Entity
@Table(name = "z_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="email")
    private String email;
    @Column(name="fio")
    private String fio;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="phone")
    private String phone;
    @Column(name="is_active")
    private boolean isActive;

    public User() {
    }

    public User(String email,String fio, String login, String password,  String phone,boolean isActive) {
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.isActive=isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
