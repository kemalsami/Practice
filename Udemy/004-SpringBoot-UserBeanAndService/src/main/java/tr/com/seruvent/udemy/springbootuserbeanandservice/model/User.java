package tr.com.seruvent.udemy.springbootuserbeanandservice.model;

import java.util.Date;

public class User {

    private int id;
    private String mail;
    private Date birthdate;

    public User(int id, String mail){
        this.id = id;
        this.mail = mail;
        this.birthdate = new Date();
    }

    public User(String mail){
        this.mail = mail;
        this.birthdate = new Date();
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    // Jakson tarafından alınıp alınmadığını göstermek için eklendi
    public String getDummyAttribute(){
        return this.mail;
    }
}
