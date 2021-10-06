package tr.com.seruvent.udemy.springboothateoas.model;

import javax.validation.constraints.*;
import java.util.Date;

public class User {

    @Positive
    private int id;
    @Size(min = 4)
    @Email
    @NotNull
    private String mail;
    private Date createdAt;

    public User(int id, String mail, Date createdAt) {
        this.id = id;
        this.mail = mail;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
