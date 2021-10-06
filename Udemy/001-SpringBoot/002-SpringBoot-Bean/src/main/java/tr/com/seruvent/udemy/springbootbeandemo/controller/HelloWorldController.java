package tr.com.seruvent.udemy.springbootbeandemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.springbootbeandemo.model.User;

@RestController
public class HelloWorldController {

    @RequestMapping
    public User helloWorld(){
        User user = new User("kemal");
        return user;
    }

}
