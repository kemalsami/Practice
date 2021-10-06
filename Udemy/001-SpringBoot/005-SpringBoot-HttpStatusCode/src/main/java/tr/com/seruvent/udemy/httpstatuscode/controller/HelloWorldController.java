package tr.com.seruvent.udemy.httpstatuscode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class HelloWorldController {


    @GetMapping(path = "response-entity-example/{name}")
    public String helloWorld(@PathVariable String name){
        return "Hello " + name;
    }

    @PostMapping(path = "response-entity-example-1")
    public ResponseEntity<Object> responseEntityExample1(@RequestParam String name){
        return ResponseEntity.ok("ResponseEntity return with name parameter " + name);
    }

    @PostMapping(path = "response-entity-example-2")
    public ResponseEntity<Object> responseEntityExample2(@RequestParam String name){
        // This function return url location to response header
        URI locationURI = ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/{name}")
                                .buildAndExpand(name)
                                .toUri();

        return ResponseEntity.created(locationURI).build();
    }

    /**
     * response-entity-example-3 örneğinde uri değeri bizim istediğimiz şekilde üretilmiştir
     *
     * response-entity-example-2 örneğinde ise uri otomatik olarak üretilmiştir yani olması gereken durum response-entity-example-2 örneğindeki gibidir
     */
    @PostMapping(path = "response-entity-example-3")
    public ResponseEntity<Object> responseEntityExample3(@RequestParam String name){
        URI locationURI = URI.create("response-entity-example/" + name);
        return ResponseEntity.created(locationURI).build();
    }

}
