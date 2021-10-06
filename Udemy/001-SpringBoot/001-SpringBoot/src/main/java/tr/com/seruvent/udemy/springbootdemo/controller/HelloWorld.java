package tr.com.seruvent.udemy.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    /**
     * @RequestMapping path tanımlanmazsa ise part default "/" olarak ayarlanır
     *
     * Fonksiyonların return etmesi zorunlu değildir
     */
    @RequestMapping
    public void helloWorld(){
        String response = "helloWorld with default path";
        System.out.println(response);
    }


/*
    @RequestMapping
    public void helloWorldDef(){
        String response = "helloWorldDefault with default path";
        System.out.println(response);
    }
*/

    @GetMapping(path = "hello-world-default")
    public String helloWorldDefault(){
        String response = "helloWorldDefault return String value";
        System.out.println(response);
        return response;
    }


    @GetMapping(path = "hello-world-application-sql" , produces = "application/pdf")
    public String helloWorldProducesSQL(){
        String response = "helloWorldProducesJson produces application/sql";
        System.out.println(response);
        return response;
    }


    @GetMapping(path = "hello-world-application-json" , produces = "application/json")
    public String helloWorldProducesJson(){
        String response = "helloWorldProducesJson produces application/json";
        System.out.println(response);
        return response;
    }

}
