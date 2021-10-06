package tr.com.seruvent.udemy.springboothateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.ServletContextApplicationContextInitializer;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.com.seruvent.udemy.springboothateoas.exception.UserNotFoundException;
import tr.com.seruvent.udemy.springboothateoas.model.User;
import tr.com.seruvent.udemy.springboothateoas.service.UserService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     *
     * @return
     */
    @GetMapping(path = "users", name = "user-list")
    public List<User> getUserList(){
        return userService.findAll();
    }


    /**
     *
     * @param id
     * @return
     *
     * NOT#1 EntityModel ile response body'e ek olarak linklerin eklenmesi sağlanır
     * NOT#2 EntityModel content-type olarak application/hal+json döner
     */
    @GetMapping(path = "users/{id}")
    public EntityModel getUser(@PathVariable int id){
        User user = userService.findById(id);

        if(user==null)
            throw new UserNotFoundException("User " + id + " not found");

        EntityModel entityModel = EntityModel.of(user);

        // Adding model links
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUserList());
        entityModel.add(webMvcLinkBuilder.withSelfRel());
        entityModel.add(webMvcLinkBuilder.withRel("all-users"));
        entityModel.add(new Link("http://localhost:8080/users"));

        return entityModel;
    }


    /**
     * @param user
     * @return
     *
     * NOT :: PostMapping ile response body dönülmemektedir. Sadece Post işleminde valid olmama durumu handle edilmelidir
     */
    @PostMapping(path = "users")
    public ResponseEntity saveUser(@Valid @RequestBody User user){

        userService.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        ResponseEntity responseEntity = ResponseEntity.created(location).build();
        return responseEntity;
    }

}
