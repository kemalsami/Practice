# Microservices - Spring Cloud 

## İçindekiler

1. [Gereksinimler](#gereksinimler)
2. [Profiles](#profiles)
3. [Application Environment](#application-environment)
4. [Kaynaklar](#kaynaklar)

## Gereksinimler
* Java 1.8
* Spring Boot 2.5.5
* Spring Web
* Spring Boot DevTools
* Actuator
* Config Client
* Config Server


## Profiles
Spring uygulama ortamlarının ayrılmasını sağlayan yapıdır. Uygulamaların farklı ortamlarda(environment) farklı ayarları bulunabilir. Örn. production ortamında kullanılan veritabanı bağlantıları ile geliştirme ortamındaki bağlantı farklıdır.

`@Profile` annotation `@Component`, `@Configuration` ve `@ConfigurationProperties` ile birleştirilip kullanıldığı yerde belirtilen ortamlarda çalışmasını sağlar.

```java
@Configuration(proxyBeanMethods = false)
@Profile("production")
public class ProductionConfiguration {

    // ...

}
```

Annotation yerine application.properties içerisinde `spring.profiles.active` şeklinde kullanılarak tüm uygulamaya etki edebilir.


## Application Environment

Mikro servislerin farklı ortamları bulunabilir. Config Server bu ortamları yayınlayabilir ancak seçmesi gereken taraf Config Client tarafıdır.

Ortamını değiştirmek istediğimiz Config Client servisi için aşağıdaki gibi değişiklik yapılmalıdır. Örneğin `dummy-service` adında bir mikro servisimiz olsun. Config Server tarafında yayınlanırken `dummy-service.properties` adında olmalıdır. `dev` ortamındaki ayarları ise `dummy-service-dev.properties` şeklinde tutulmalıdır.
```properties
spring.profiles.active=dev
```

Sonuç olarak config client application.properties altında hangi ortamın kullanılacağı `spring.profiles.active` değerinde belirlenir. 

Config server ise ilgili ortam dosyasını örn. `dev` için `APPLICATIONNAME-dev.properties` şeklinde tutmalıdır.


## Kaynaklar

- https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.profiles
- 