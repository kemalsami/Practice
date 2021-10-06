package tr.com.seruvent.udemy.springbootvalidation.model;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private int id;
    @Size(min = 4 , message = "Users name min size should be at least 4")
    private String name;
    @Size(min = 4 , message = "Users name min size should be at least 4")
    private String surname;
    @NotNull
    private String mail;
    @Past
    private Date birth;

    public User(){}

    public User(int id, String name, String surname, String mail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.birth = new Date();
    }

    public User(int id, String name, String surname, String mail, Date birth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.birth = birth;
    }

    public User(String name, String surname, String mail, Date birth) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
