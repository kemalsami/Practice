package tr.com.seruvent.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.example.bean.User;
import tr.com.seruvent.example.bean.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable  int id){
        return userService.findOne(id);
    }

}
