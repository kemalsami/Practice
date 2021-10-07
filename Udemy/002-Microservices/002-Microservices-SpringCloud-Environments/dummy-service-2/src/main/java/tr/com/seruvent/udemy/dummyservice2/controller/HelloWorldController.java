package tr.com.seruvent.udemy.dummyservice2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.seruvent.udemy.dummyservice2.config.Configuration;

@RestController
public class HelloWorldController {

    @Autowired
    private Configuration configuration;

    @GetMapping(path = "hello-world")
    public Configuration helloWorld(){
        return configuration;
    }

}
