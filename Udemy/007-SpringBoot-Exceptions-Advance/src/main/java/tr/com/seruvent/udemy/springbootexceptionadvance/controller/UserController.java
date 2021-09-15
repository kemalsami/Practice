package tr.com.seruvent.udemy.springbootexceptionadvance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tr.com.seruvent.udemy.springbootexceptionadvance.exception.UserNotFoundException;
import tr.com.seruvent.udemy.springbootexceptionadvance.model.User;
import tr.com.seruvent.udemy.springbootexceptionadvance.service.UserService;

import java.rmi.NoSuchObjectException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "users")
    public List<User> getUserList(){
        return userService.findAll();
    }

    @GetMapping(path = "users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.findUser(id);

        if(user==null)
            throw new UserNotFoundException("user id:" + id + " not found");

        return user;
    }

    /**
     *
     * Bu method örnek amacıyla oluşturulmuştur
     *
     * NullPointerException, CustomResponseEntityExceptionHandler içerisinde ExceptionHandler altında tanımlanmıştır
     * Bunun anlamı NullPointerException üretildiğinde @ExceptionHandler altında belirtilen fonsiyonu çağır
     * @ExceptionHandler altındaki customExceptionHandler fonksiyonu ile istenilen ResponseEnetity değeri dönülür
     *
     */
    @GetMapping(path = "null-pointer-exception")
    public User userException(){

        if(true)
            throw new NullPointerException();

        return null;
    }

}
