package tr.com.seruvent.udemy.springcloudhelloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.springcloudhelloworld.config.Configuration;
import tr.com.seruvent.udemy.springcloudhelloworld.model.Limits;

@RestController
public class HelloWorldController {

    @Autowired
    private Configuration configuration;

    @GetMapping(path = "hello-world")
    public Limits helloWorld(){
        Limits limits = new Limits(configuration.getMinimum(),configuration.getMaximum());
        return limits;
    }

}
