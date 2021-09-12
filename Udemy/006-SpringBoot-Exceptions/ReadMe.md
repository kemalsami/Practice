# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [HTTP Status Code](#http-status-code)
3. [@ResponseStatus](#responsestatus)
4. [Annotations](#annotations)
5. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 * Spring Web
 * Spring Boot DevTools


## ResponseEntity
Gelen isteklerin `http status code` değerleri ile dönülmesi ResponseEntity ile sağlanır.

Örneğin bir post işleminde response olarak herhangi bir değer dönülmesine gerek yoktur. İşlemin gerçekleştirilip gerçekleştirilmediği hakkında bir bilgi verilmesi yeterli olacaktır. 

> Response header status code değerine dikkat edilmedi gerekir.  
> 
> Örn. ResponseEntity.created() ile `201` durum kodu dönerken ResponseEntity.ok() ile `200` durum kodu dönmektedir.

```java
@RestController
public class UserController {

    @PostMapping(path = "users")
    public ResponseEntity saveUser(@RequestBody User user){
        userService.saveUser(user);

        URI location = ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/id/{user.id}")
                                .buildAndExpand(user.getId())
                                .toUri();

        return ResponseEntity.created(location).build();
    }
}
```

## @ResponseStatus

`@ResponseStatus` annotation olmaması durumunda default olarak Spring exception'lar için `500 status code` dönmektedir.  

`@ResponseStatus` annotation ile dönecek olan objenin http status code değerini istediğimiz şekilde düzenleyebiliriz.

```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg){
        super(msg);
    }

}
```

`@ResponseStatus` annotation tanımlamasına baktığımızda `TYPE` ve `METHOD` olarak kullanılabildiği görülmektedir. Bunun anlamı `@ResponseStatus` annotation class tanımlamalarından ve fonsiyonlardan önce kullanılabilir. 

```java
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
// ...
public @interface ResponseStatus {
    // ... 
}
```


## Annotations
Spring framework'te kullanılan annotation'ları genel olarak aşağıdaki gibi sınıflandırabiliriz.

- @SpringBootApplication
- @RestController
- @RequestMapping / @GetMapping / @PostMapping 
- @ResponseStatus / @ResponseCode / @ResponseEntity
- @PathVarible / @RequestBody / @RequestParam
  

## Kaynaklar
- https://spring.io/projects/spring-boot
- 

