package tr.com.seruvent.udemy.springbootexceptions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.springbootexceptions.model.User;
import tr.com.seruvent.udemy.springbootexceptions.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "users")
    public List<User> listUsers(){
        return userService.findAll();
    }


    // POST User and return ResponseEntity example
    // GET User example
    // Exception Example

}
