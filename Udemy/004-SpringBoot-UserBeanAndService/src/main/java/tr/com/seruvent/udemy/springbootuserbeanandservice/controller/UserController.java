package tr.com.seruvent.udemy.springbootuserbeanandservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.springbootuserbeanandservice.model.User;
import tr.com.seruvent.udemy.springbootuserbeanandservice.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "user/{id}")
    public User getUser(@PathVariable int id){
        return null;
    }

    @GetMapping(path = "users")
    public List<User> userList(){
        return userService.getUserList();
    }



}
