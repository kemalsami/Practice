package tr.com.seruvent.udemy.springbootexceptions.model;

import java.util.Date;

public class User {

    private int id;
    private String mail;
    private String name;
    private String surname;
    private Date birth;

    public User(){}

    public User(String mail) {
        this.mail = mail;
        this.birth = new Date();
    }

    public User(String mail, String name, String surname) {
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.birth = new Date();
    }

    public User(int id, String mail, String name, String surname) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.birth = new Date();
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}



