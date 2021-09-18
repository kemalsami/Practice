package tr.com.seruvent.udemy.springbootvalidation.exception;

import com.sun.tools.internal.ws.processor.model.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleNotFoundException(Exception ex, WebRequest request){
        CustomException customException = new CustomException(new Date() , ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(customException , HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        CustomException customException = new CustomException(new Date() , "Validation Error - handleMethodArgumentNotValid" , ex.getBindingResult().toString());
        return new ResponseEntity(customException , HttpStatus.BAD_REQUEST);
    }

}
