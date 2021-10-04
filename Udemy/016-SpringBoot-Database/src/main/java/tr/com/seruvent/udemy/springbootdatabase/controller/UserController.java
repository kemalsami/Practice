package tr.com.seruvent.udemy.springbootdatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.seruvent.udemy.springbootdatabase.model.User;
import tr.com.seruvent.udemy.springbootdatabase.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(path = "users")
    public List<User> getUserList(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @GetMapping(path = "users/{id}")
    public User getUser(@PathVariable int id){
        Optional<User> optionalUser = userRepository.findById(id);

        if(!optionalUser.isPresent())
            throw new RuntimeException("NOT Found");

        return optionalUser.get();
    }

    @PostMapping(path = "users")
    public User postUser(@RequestBody User user){
        User newUser = userRepository.save(user);
        return newUser;
    }

    @DeleteMapping(path = "users/{id}")
    public void deleteUser(@PathVariable int id){

    }

}
