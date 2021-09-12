package tr.com.seruvent.udemy.springbootexceptions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.com.seruvent.udemy.springbootexceptions.exception.UserNotFoundException;
import tr.com.seruvent.udemy.springbootexceptions.model.User;
import tr.com.seruvent.udemy.springbootexceptions.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(path = "users")
    public List<User> listUsers(){
        return userService.findAll();
    }


    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.findUser(id);

        // UserNotFoundException
        if(user==null)
            throw new UserNotFoundException(String.format("User %o Not Found" , id));

        return user;
    }


    @PostMapping(path = "users")
    public ResponseEntity saveUser(@RequestBody User user){
        userService.saveUser(user);

        //URI location = URI.create(String.format("localhost:8081/users/%o" , user.getId()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id/{user.id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
