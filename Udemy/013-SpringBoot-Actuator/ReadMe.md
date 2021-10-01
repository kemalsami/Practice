# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Actuator](#actuator)
3. [Actuator Dependencies](#actuator-dependencies)
4. [Actuator HTTP Endpoints](#actuator-http-endpoints)
5. [Actuator Settings](#actuator-settings)
6. [HAL Explorer](#hal-explorer)
7. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 * Spring Web
 * Spring Boot DevTools
 * Validation
 * HATEOAS
 * Actuator
 * HAL Explorer


## Actuator
Spring Boot birçok özelliğe sahiptir. Uygulamanın `production` ortamına konulduğunda izlenmesi(monitor) ve yönetilmesi(manage) gerekir.

`Actuator` ile yönetme ve izleme için aşağıdakilerden biri kullanılabilir. 
- HTTP endpoints
- JMX (Java Management Extensions)

`Actuator` tarafından default olarak `HTTP endpoints` kullanılmaktadır.  


## Actuator Dependencies
Spring actuator özelliğinin kullanılabilmesi için proje oluşturulurken Ops başlığı altından `actuator` bağımlılığı eklenir.

![Actuator Depency](./images/actuator-dependecy-01.png)

Direk dependency olarak eklemek istiyorsak maven projesi için `pom.xml` dosyasına aşağıdaki gibi `actuator` bağımlılığı eklenir.
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <!-- other dependecies -->
</dependencies>
```


## Actuator HTTP Endpoints
Spring uygulamasına bağımlılık eklendikten sonra `/actuator` (localhost:8080/actuator) ile uygulama monitor edilebilir.

- [http://localhost:8080/actuator](http://localhost:8080/actuator)

![Actuator Default](./images/actuator-browser-01.png)


## Actuator Settings
`Actuator` üzerinden HTTP endpoints aracılığıyla uygulamanın durumu görüntülenebilir. Her endpoint ayrı ayrı `enable` ya da `disable` edilebilir.

Default olarak sadece `health` endpoint ([/actuator/health](/actuator/health)) gösterilmektedir.

Aşağıdaki ayar, `application.properties` dosyasına eklenerek default olarak tüm endpoint'ler enable edilebilir. 
```properties
management.endpoints.web.exposure.include=*
```

![Actuator Settings All Enabled](./images/actuator-browser-02.png)


## HAL Explorer
`HAL Explorer` aslında HATEOS gibi belirli formatta olan REST sorguları için geliştiricilere kolaylık sağlar. 

>Bazı REST standartları aşağıdaki gibidir. 
>- HATEOAS 
>- HAL (Hypertext Application Language)
>- JSON-LD
>- SIREN
>- ...


Dependency olarak eklemek için maven projesi için `pom.xml` dosyasına aşağıdaki gibi `hal explorer` bağımlılığı eklenir.
```xml
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-rest-hal-explorer</artifactId>
</dependency>
```

HAL Explorer arayüzüne [localhost:8080](localhost:8080) üzerinden erişilebilir. 

`Actuator` her ne kadar uygulama hakkında bilgi verse de bu verilerin görsel olarak daha rahat şekilde gösterilebilmesi için `HAL Explorer` kullanılmaktadır. Actuator, HATEOAS formatında olduğundan `HAL Explorer` ile kullanılabilir.

Actuator arayüzüne [localhost:8080/actuator](localhost:8080/actuator) üzerinden erişilebilir.

## Kaynaklar
- https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html
- https://spring.io/projects/spring-boot
- https://sookocheff.com/post/api/on-choosing-a-hypermedia-format/
