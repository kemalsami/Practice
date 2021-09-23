package tr.com.seruvent.udemy.springbootactuator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.com.seruvent.udemy.springbootactuator.exception.UserNotFoundException;
import tr.com.seruvent.udemy.springbootactuator.model.User;
import tr.com.seruvent.udemy.springbootactuator.service.UserService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "users")
    public List<User> getUserList(){
        return userService.findAll();
    }

    @GetMapping(path = "users/{userId}")
    public EntityModel getUserById(@PathVariable int userId){
        User user = userService.findUserById(userId);

        if(user==null)
            throw new UserNotFoundException("User not found");

        EntityModel entityModel = EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUserList());
        entityModel.add(webMvcLinkBuilder.withSelfRel());

        return entityModel;
    }

    @PostMapping(path = "users")
    public ResponseEntity saveUser(@Valid @RequestBody User user){
        userService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
