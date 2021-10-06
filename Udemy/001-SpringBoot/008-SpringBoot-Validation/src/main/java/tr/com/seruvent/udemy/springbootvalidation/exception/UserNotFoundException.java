package tr.com.seruvent.udemy.springbootvalidation.exception;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

}
