package tr.com.seruvent.udemy.springbootdatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.seruvent.udemy.springbootdatabase.model.User;
import tr.com.seruvent.udemy.springbootdatabase.service.UserService;

import java.util.List;

@RestController
public class UserController {

    /*
    @Autowired
    private UserService userService;
     */


    @GetMapping(path = "users")
    public List<User> getUserList(){
        //List<User> userList = userService.findAll();
        return null;
    }

    @GetMapping(path = "users/{id}")
    public void getUser(@PathVariable int id){

    }

    @PostMapping(path = "users")
    public void postUser(@RequestBody User user){

    }

    @DeleteMapping(path = "users/{id}")
    public void deleteUser(@PathVariable int id){

    }

}
