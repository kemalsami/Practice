# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [@Component / @Autowired](#component--autowired)
4. [@RequestBody](#requestbody)
5. [JACKSON](#jackson)
6. [JACKSON Setting](#jackson-settings)
7. [Olası Hatalar](#olası-hatalar)
8. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 * Spring Web
 * Spring Boot DevTools


## @Component | @Autowired
UserService class'ta `@Component` annotation kullanılmıştır. `@Autowired` kullanılabilmesi için gerekli olduğundan eklenmiştir.

`@Autowired` ile bir obje oluşturduğumuzda `new` ile başlayan Constructor seçmemize gerek kalmaz. Otomatik olarak uygun olan contructor ile obje yaratılır.

## @RequestBody

- @SpringBootApplication
  - Spring auto-configuration yapılandırılmasını sağlar
- @Component / @Autowired
- @RestController
- @RequestMapping / @GetMapping / @PostMapping
  - request'lerin map edilmesinde kullanılır
- `@PathVarible / @RequestBody`
  - request parametrelerinin fonsiyonlara aktarılmasını sağlarlar
  
> Gelen istekte, path üzerindeki değeri almak istiyorsak `@PathVariable` annotation kullanılır. Bazı durumlarda ise url üzerinden alınacak değerler yeterli olmaz. Gelen istekten daha fazla değer alabilmek için isteğin body değerine bakılır. Body içerisindeki değerler `@RequestBody` annotation ile fonksiyonlara aktarılır.

Aşağıdaki örnekte olduğu gibi gelen isteğin body değeri otomatik olarak `User` objesine çevrilmektedir.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.seruvent.udemy.springbootuserbeanandservice.model.User;
import tr.com.seruvent.udemy.springbootuserbeanandservice.service.UserService;

@RestController
public class UserController {

  @Autowired
  UserService userService;
  
  // Other functions  

  @PostMapping(path = "users")
  public void createUser(@RequestBody User user){
    userService.saveUser(user);
  }

}
```


## JACKSON
Spring auto-configuration ile Jackson otomatik olarak etkinleştirilmektedir. Bu kütüphane sayesinde response olarak dönülen objeler otomatik olarak JSON formatında dönmektedir.

> ***UYARI***  
> Bir bean oluştururken getter ve setter metodları ile oluşturmamız gerekmektedir. Jackson otomatik olarak getter metodlarında tanımlanan değerleri almaktadır. 
> 
> Örneğin User bean içerisinde test için getDummyAttribute() oluşturduğumuzda bu değer dönecektir. Yani User bean niteliklerine getDummyAttribute() fonksiyonundan dönen değer eklenecektir.


## JACKSON Settings
`application.properties` dosyasında Jackson ayarları yapılabilmektedir. Spring framework'te Jackson kütüphanesinin görevi response dönen objelerin JSON formatında dönmesini sağlamaktır.

Spring 2.0 sonrasında default olarak Date objesi için `2021-09-11T16:57:48.342+00:00` formatında dönmektedir. application.properties dosyasından bazı objelerin formatları değiştirilebilmektedir.

```properties
# JACKSON
spring.jackson.date-format = YYYY-MM-dd
spring.jackson.serialication.write-dates-as-timestamps=false
```


## Olası Hatalar
Spring Boot çalıştırılırken aşağıdaki hatalar ile karşılaşılabilir.

## Kaynaklar
- https://spring.io/projects/spring-boot

