package tr.com.seruvent.udemy.springbootexceptionadvance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity customExceptionHandler(){
        System.out.println("My Custom Exception returns 404 and CustomException");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomException(new Date(),"my message" , "CustomResponseEntityExceptionHandler.customExceptionHandler()"));
    }

}
