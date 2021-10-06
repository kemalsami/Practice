package tr.com.seruvent.udemy.springbootactuator.exception;

import java.util.Date;

public class CustomException {

    private static int count=0;
    private int exceptionCount=0;
    private Date timestamp;
    private String message;
    private String description;

    public CustomException(String message, String description) {
        ++count;
        exceptionCount=count;
        this.timestamp = new Date();
        this.message = message;
        this.description = description;
    }

    public int getExceptionCount() {
        return this.exceptionCount;
    }

    public void setExceptionCount(int exceptionCount) {
        this.exceptionCount = exceptionCount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
