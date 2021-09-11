package tr.com.seruvent.example.bean;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String msg){
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString(){
        return "HelloWorldBean::" + this.message;
    }
}
