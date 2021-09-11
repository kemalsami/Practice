# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [BEAN](#bean)
3. [APPLICATION.PROPERTIES](#application.properties)
4. [Auto-Configuration](#auto-configuration)
5. [DispatcherServlet](#dispatcherservlet)
6. [Olası Hatalar](#olası-hatalar)
    1. [Could not find acceptable representation](#could-not-find-acceptable-representation)
7. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 
 * Spring Web
 * Spring Boot DevTools


## BEAN
 
## APPLICATION.PROPERTIES
`application.properties` dosyasında Spring ile alakalı konfigürasyon değerleri ayarlanmaktadır. 

Spring Boot detaylı log için debug mode aktifleştirilebilir.

```properties
# Spring log settings
logging.level.org.springframework = debug
logging.file.name = ./log/spring-boot-bean-demo.log
```
 
 
## Auto-Configuration

Aşağıdaki kod parçasında görüldüğü üzere Spring uygulamasında `@SpringBootApplication` bulunmaktadır. 

`@SpringBootApplication` ile uygulamanın ihtiyacı olan tüm konfigürasyonlar yapılır.   

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootbeandemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbeandemoApplication.class, args);
    }

}
```

`application.properties` dosyasında eğer log level debug yaparsak Spring uygulaması başlarken nelerin konfigüre edildiği görülebilir.

```properties
# Spring log settings
logging.level.org.springframework = debug
``` 

Default olarak aşağıdaki konfigürasyonlar yapılmaktadır. Spring debug mode loglarına bakıldığında `DispatcherServletAutoConfiguration` ve `ErrorMvcAutoConfiguration` gibi konfigürasyon class'larının kullanıldığı görülür.

`DispatcherServletAutoConfiguration` -> request mapping durumlarını handle eder
`ErrorMvcAutoConfiguration` -> spring hatalarını handle eder (bean getter metodu yazılmamasında ErrorMvcAutoConfiguration.WhitelabelErrorViewConfiguration çağrılmaktadır)

```
...
...

============================
CONDITIONS EVALUATION REPORT
============================


Positive matches:
-----------------

   AopAutoConfiguration matched:
      - @ConditionalOnProperty (spring.aop.auto=true) matched (OnPropertyCondition)

   AopAutoConfiguration.ClassProxyingConfiguration matched:
      - @ConditionalOnMissingClass did not find unwanted class 'org.aspectj.weaver.Advice' (OnClassCondition)
      - @ConditionalOnProperty (spring.aop.proxy-target-class=true) matched (OnPropertyCondition)

   DispatcherServletAutoConfiguration matched:
      - @ConditionalOnClass found required class 'org.springframework.web.servlet.DispatcherServlet' (OnClassCondition)
      - found 'session' scope (OnWebApplicationCondition)

   DispatcherServletAutoConfiguration.DispatcherServletConfiguration matched:
      - @ConditionalOnClass found required class 'javax.servlet.ServletRegistration' (OnClassCondition)
      - Default DispatcherServlet did not find dispatcher servlet beans (DispatcherServletAutoConfiguration.DefaultDispatcherServletCondition)

   DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration matched:
      - @ConditionalOnClass found required class 'javax.servlet.ServletRegistration' (OnClassCondition)
      - DispatcherServlet Registration did not find servlet registration bean (DispatcherServletAutoConfiguration.DispatcherServletRegistrationCondition)

   DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration#dispatcherServletRegistration matched:
      - @ConditionalOnBean (names: dispatcherServlet types: org.springframework.web.servlet.DispatcherServlet; SearchStrategy: all) found bean 'dispatcherServlet' (OnBeanCondition)

   ...
   ...

   ErrorMvcAutoConfiguration matched:
      - @ConditionalOnClass found required classes 'javax.servlet.Servlet', 'org.springframework.web.servlet.DispatcherServlet' (OnClassCondition)
      - found 'session' scope (OnWebApplicationCondition)

   ErrorMvcAutoConfiguration#basicErrorController matched:
      - @ConditionalOnMissingBean (types: org.springframework.boot.web.servlet.error.ErrorController; SearchStrategy: current) did not find any beans (OnBeanCondition)

   ErrorMvcAutoConfiguration#errorAttributes matched:
      - @ConditionalOnMissingBean (types: org.springframework.boot.web.servlet.error.ErrorAttributes; SearchStrategy: current) did not find any beans (OnBeanCondition)

   ErrorMvcAutoConfiguration.DefaultErrorViewResolverConfiguration#conventionErrorViewResolver matched:
      - @ConditionalOnBean (types: org.springframework.web.servlet.DispatcherServlet; SearchStrategy: all) found bean 'dispatcherServlet'; @ConditionalOnMissingBean (types: org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver; SearchStrategy: all) did not find any beans (OnBeanCondition)

   ErrorMvcAutoConfiguration.WhitelabelErrorViewConfiguration matched:
      - @ConditionalOnProperty (server.error.whitelabel.enabled) matched (OnPropertyCondition)
      - ErrorTemplate Missing did not find error template view (ErrorMvcAutoConfiguration.ErrorTemplateMissingCondition)

   ErrorMvcAutoConfiguration.WhitelabelErrorViewConfiguration#beanNameViewResolver matched:
      - @ConditionalOnMissingBean (types: org.springframework.web.servlet.view.BeanNameViewResolver; SearchStrategy: all) did not find any beans (OnBeanCondition)

   ErrorMvcAutoConfiguration.WhitelabelErrorViewConfiguration#defaultErrorView matched:
      - @ConditionalOnMissingBean (names: error; SearchStrategy: all) did not find any beans (OnBeanCondition)

...
...

```
 
## DispatcherServlet 

The requesting processing workflow in Spring Web MVC

![DispatcherServlet Diagram](./images/dispatcherServletDiagram.png)

DispatcherServlet ile bilinmesi gereken 2 konu bulunmaktadır. DispatcherServlet sadece gelen request'leri dağıtmakla kalmıyor. Aynı zamanda `Spring IoC` (inversion of control) ile tam entegre olduğundan Spring'in sağladığı her özelliği kullanmaktadır.  
- Inversion of Control
- Dependency Injection


## Olası Hatalar
Spring Boot çalıştırılırken aşağıdaki hatalar ile karşılaşılabilir.


### Could not find acceptable representation

Spring'te oluşturduğumuz modelleri bean olarak tanımlayabiliriz. Response olarak bir obje dönmemiz durumunda ekranda aşağıdaki gibi bir hata ile karşılaşabiliriz.   

`Could not find acceptable representation` hatasının sebebi, oluşturduğumuz bean içerisinde get metodlarının bulunmamasından kaynaklanır.

Örn. User class'ı oluşturalım ve içerisinde name attribute tanımlayalım. Eğer `getName()` metodu bulunmaz ise aşağıdaki hata ile karşılaşılacaktır.  

```
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Thu Sep 09 17:09:28 EEST 2021
There was an unexpected error (type=Not Acceptable, status=406).
Could not find acceptable representation
org.springframework.web.HttpMediaTypeNotAcceptableException: Could not find acceptable representation
	at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:315)
	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.handleReturnValue(RequestResponseBodyMethodProcessor.java:183)
	at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:78)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:124)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1064)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)...
```
    
    
## Kaynaklar
- https://spring.io/projects/spring-boot
- https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-introduction
- https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-auto-configuration.html
- https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/ch15s02.html
- https://www.baeldung.com/spring-bean

