# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [REST](#rest)
3. [Controller](#controller)
4. [RequestMapping & GetMapping](#requestmapping--getmapping)
5. [Olası Hatalar](#olası-hatalar)
    1. [There is already bean method](#there-is-already-bean-method)
6. [Kullanışlı Kaynaklar](#kullanışlı-kaynaklar)
	

## Gereksinimler
 
 * Spring Web
 * Spring Boot DevTools


## REST
 
 REST(Representational State Transfer) 
 
 Create a User - POST /users  
 Delete a User - DELETE /users/1  
 Get all Users - GET /users  
 Get one Users - GET /users/1  
 
 
 ![Kimlik Sağlayıcı Giriş Sayfası](./img/error-ldap-access-right-1.png)  
 ![Kimlik Sağlayıcı Shibboleth Logları](./img/error-ldap-access-right-2.png)
   
## Controller

 Spring'te kullanılabilecek başlıca 2 Controller annotation bulunmaktadır.   
 - @RestController
 - @Controller
 
 REST API kullanımını kolaylaştırmak için @Controller annotation özelleştirilerek @RestController oluşturulmuştur. 
 
 `@RestController` içerisinde `@Controller` ile `@ResponseBody` bulundurmaktadır. @RestController ile bir class oluşturduğumuzda, methodların her birine @ResponseBody eklememize gerek kalmayacaktır.   

@RestController örneği
```java 
@RestController 
public class Book{ 

    @RequestMapping(value={"/book"}) 
    public Book getBook(){ 
        //... 
        return book; 
    } 
}
```

@Controller örneği
```java 
@Controller 
public class Book{ 
    @RequestMapping(value={"/book"}) 
    @ResponseBody 
    public Book getBook(){ 
        //... 
        return book; 
    } 
}
```

##### @RestController 
```
 @Target(value=TYPE)  
 @Retention(value=RUNTIME)  
 @Documented  
 @Controller  
 @ResponseBody  
 public @interface RestController   
``` 

##### @Controller 
```
 @Target(value=TYPE)  
 @Retention(value=RUNTIME)  
 @Documented  
 @Component    
 public @interface Controller   
``` 

## RequestMapping & GetMapping

- @RequestMapping ek olarak method parametresi alırken @GetMapping `method=RequestMethod.GET` değerini default olarak almıştır.

- @RequestMapping class ve fonksiyonlar öncesinde kullanılabilirken, @GetMapping sadece fonksiyonlardan önce kullanılmaktadır.

```
@RequestMapping(method = RequestMethod.GET, path = "/get/{id}")  
```

```
@GetMapping(path = "/get/{id}")
```

## Olası Hatalar
Spring Boot çalıştırılırken aşağıdaki hatalar ile karşılaşılabilir.


### There is already bean method

Aynı path değerine sahip birden fazla metod oluşturulması durumunda aşağıdaki hata ile karşılaşılabilir. Bunun anlamı `helloWorldDefault` metodu ile `helloWorld` metodları aynı path değerine map ediyorlarmış. 

```
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'requestMappingHandlerMapping' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Invocation of init method failed; nested exception is java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'helloWorld' method 
tr.com.seruvent.udemy.springbootdemo.controller.HelloWorld#helloWorldDefault()
to {GET []}: There is already 'helloWorld' bean method
tr.com.seruvent.udemy.springbootdemo.controller.HelloWorld#helloWorld() mapped.
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1786) ~[spring-beans-5.3.9.jar:5.3.9]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:602) ~[spring-beans-5.3.9.jar:5.3.9]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:524) ~[spring-beans-5.3.9.jar:5.3.9]
...
```

Aynı hatanın devamında aşağıdaki gibi ek açıklama gelebilir.

```
Caused by: java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'helloWorld' method 
tr.com.seruvent.udemy.springbootdemo.controller.HelloWorld#helloWorldDefaul()
to {GET []}: There is already 'helloWorld' bean method
tr.com.seruvent.udemy.springbootdemo.controller.HelloWorld#helloWorld() mapped.
	at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping$MappingRegistry.validateMethodMapping(AbstractHandlerMethodMapping.java:665) ~[spring-webmvc-5.3.9.jar:5.3.9]
	at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping$MappingRegistry.register(AbstractHandlerMethodMapping.java:631) ~[spring-webmvc-5.3.9.jar:5.3.9]
...
```
    
    
## Kullanışlı Kaynaklar
- https://spring.io/projects/spring-boot
- https://javarevisited.blogspot.com/2017/08/difference-between-restcontroller-and-controller-annotations-spring-mvc-rest.html#axzz75sgThmFU

