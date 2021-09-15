package tr.com.seruvent.udemy.springbootexceptionadvance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg){
        super(msg);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
