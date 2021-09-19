package tr.com.seruvent.udemy.springboothateoas.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

}
