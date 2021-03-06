package tr.com.seruvent.udemy.springbootuserbeanandservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.seruvent.udemy.springbootuserbeanandservice.model.User;
import tr.com.seruvent.udemy.springbootuserbeanandservice.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "users/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping(path = "users")
    public List<User> userList(){
        return userService.getUserList();
    }

    @PostMapping(path = "users")
    public void createUser(@RequestBody User user){
        userService.saveUser(user);
    }

}
