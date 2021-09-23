package tr.com.seruvent.udemy.springbootactuator.model;

import java.util.Date;

public class User {

    private static int counter=0;

    private int id;
    private String mail;
    private String name;
    private String surname;
    private Date createdAt;


    public User(String mail, String name, String surname) {
        ++counter;
        this.id=counter;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.createdAt = new Date();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
