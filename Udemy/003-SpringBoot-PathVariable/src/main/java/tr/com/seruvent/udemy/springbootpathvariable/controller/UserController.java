package tr.com.seruvent.udemy.springbootpathvariable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.springbootpathvariable.model.User;

@RestController
public class UserController {

    @GetMapping
    public User getUser(){
        User user = new User("kskaraca@gmail.com");
        return user;
    }


    @GetMapping(path = "user/{email}")
    public User setUset(@PathVariable String email){
        User user = new User(email);
        return user;
    }

}
