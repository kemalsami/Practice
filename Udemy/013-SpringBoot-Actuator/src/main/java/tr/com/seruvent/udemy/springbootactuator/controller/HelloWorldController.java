package tr.com.seruvent.udemy.springbootactuator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.springbootactuator.model.User;
import tr.com.seruvent.udemy.springbootactuator.service.UserService;

import java.util.List;


@RestController
public class HelloWorldController {

    @Autowired
    private UserService userService;

    /**
     * Request Header'da zorunlu olarak apikey beklenmektedir
     */
    @GetMapping(path = "hello-world")
    public List<User> getUserList(@RequestHeader(value = "apikey" , required = true) String apikey){
        return userService.findAll();
    }

}
