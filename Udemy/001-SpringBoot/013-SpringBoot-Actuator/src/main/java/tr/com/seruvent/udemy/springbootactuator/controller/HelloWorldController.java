package tr.com.seruvent.udemy.springbootactuator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    /**
     * Request Header'da zorunlu olarak apikey beklenmektedir
     */
    @GetMapping(path = "hello-world")
    public ResponseEntity getUserList(@RequestHeader(value = "apikey" , required = true) String apikey){

        if(apikey==null || apikey.length()==0)
            throw new RuntimeException("APIKEY not found");

        return ResponseEntity.ok("APIKEY :: " + apikey);
    }

}
