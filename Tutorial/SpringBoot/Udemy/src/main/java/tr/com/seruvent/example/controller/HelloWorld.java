package tr.com.seruvent.example.controller;

import org.springframework.web.bind.annotation.*;
import tr.com.seruvent.example.bean.HelloWorldBean;

@RestController
public class HelloWorld {

    @RequestMapping(method=RequestMethod.GET,path="/hello-world-old")
    public String helloWorld(){
        return "This is the oldest way";
    }

    @GetMapping(path = "/hello-world-new")
    public String helloWorldShort(){
        return "This is the short way";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Bean ile otomatik olarak JSON dönülmesi sağlanır");
    }

    @GetMapping(path = "/hello-world-bean/{msg}")
    public HelloWorldBean helloWorldBeanWithParameter(@PathVariable String msg){
        return new HelloWorldBean("Bean ile parametreden gelen mesaj yazılır :: " + msg);
    }

}
