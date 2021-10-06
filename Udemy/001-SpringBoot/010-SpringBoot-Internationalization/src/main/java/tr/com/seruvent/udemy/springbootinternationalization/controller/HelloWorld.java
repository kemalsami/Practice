package tr.com.seruvent.udemy.springbootinternationalization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorld {

    @Autowired
    MessageSource messageSource;

    @GetMapping(path = "hello-world-1")
    public ResponseEntity helloWorld(@RequestHeader(name="Accept-Language" , required = true) Locale locale){
        String content = messageSource.getMessage("hello.world" , null , locale);
        return ResponseEntity.ok(content);
    }

    @GetMapping(path = "hello-world-2")
    public ResponseEntity helloWorld(){
        String content = messageSource.getMessage("hello.world" , null , LocaleContextHolder.getLocale());
        return ResponseEntity.ok(content);
    }

}
