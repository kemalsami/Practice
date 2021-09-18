package tr.com.seruvent.udemy.springbootvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tr.com.seruvent.udemy.springbootvalidation.exception.UserNotFoundException;
import tr.com.seruvent.udemy.springbootvalidation.model.User;
import tr.com.seruvent.udemy.springbootvalidation.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(path = "users")
    public List<User> getUserList(){
        return userService.findAll();
    }


    @GetMapping(path = "users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.findById(id);

        if(user==null)
            throw new UserNotFoundException("UserNotFoundException");

        return user;
    }


    @PostMapping(path = "users")
    public void postUser(@Valid @RequestBody User user){
        userService.saveUser(user);
    }


    @DeleteMapping(path = "users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }


    // @ExceptionHandler - Validation
/*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        errors.put("dummyFieldName", "dummyValue");
        return errors;
    }
 */

}
