package tr.com.seruvent.udemy.springbootcontentnegotiation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.springbootcontentnegotiation.model.User;
import tr.com.seruvent.udemy.springbootcontentnegotiation.service.UserService;

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
    public EntityModel<User> getUser(@PathVariable int id){
        User user = userService.findById(id);

        if(user==null)
            throw new RuntimeException("User " + id + " not found");

        EntityModel entityModel = EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUserList());
        entityModel.add(webMvcLinkBuilder.withSelfRel());

        return entityModel;
    }

}
