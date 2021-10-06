package tr.com.seruvent.udemy.springbootexceptionadvance.exception;

import java.util.Date;

public class CustomException {

    private Date date;
    private String msg;
    private String description;

    public CustomException(Date date, String msg, String description) {
        this.date = date;
        this.msg = msg;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
