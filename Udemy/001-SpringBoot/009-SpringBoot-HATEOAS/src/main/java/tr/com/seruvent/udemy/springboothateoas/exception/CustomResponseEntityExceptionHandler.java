package tr.com.seruvent.udemy.springboothateoas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleUserNotFoundException(Exception ex, WebRequest request){
        CustomException customException = new CustomException(new Date() , ex.getMessage() , request.getDescription(false));
        return new ResponseEntity(customException , HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        CustomException customException = new CustomException(new Date() , "Validation Exception" , ex.getBindingResult().toString());
        return new ResponseEntity(customException, HttpStatus.BAD_REQUEST);
    }

}
