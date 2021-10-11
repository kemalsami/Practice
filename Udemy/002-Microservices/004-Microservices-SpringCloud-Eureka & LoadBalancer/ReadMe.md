# Microservices - Spring Cloud 

## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Servisler](#servisler)
3. [Naming Server Eureka](#naming-server-eureka)
4. [Eureka Discovery Client](#eureka-discovery-client)
5. [Cluster](#cluster)
6. [Eureka Test](#eureka-test)
7. [Kaynaklar](#kaynaklar)

## Gereksinimler
* Java 1.8
* Spring Boot 2.5.5
* Spring Web
* Spring Boot DevTools
* Actuator
* Eureka Server
* Eureka Client


## Servisler

Projenin genel yapısı aslında aşağıdaki gibidir. `Currency Exchange` servisi H2 veritabanı üzerinden verileri çekmektedir. `Currency Conversion` ise `Currency Exchange` servisinden aldığı verileri kullarak sayıya göre değer hesaplamaktadır. 
![Servisler - 1](./images/services-1.png)

Her servisin tek olması ve toplam servis sayısının az olması durumunda bir sorun olmayacaktır. Ancak servis sayısı artması durumunda servis isimlerinin yönetilmesi gerekecektir.

Dolayısıyla projeye `naming server` eklenmesi ihtiyacı doğmuştur. Bu sayede bir servis diğer servisi eureka üzerinde tanımlı oldukları isimleriyle erişebilecekler.
![Servisler - 2](./images/services-2.png)


Mikro servislerin son hali ise aşağıdaki gibidir. Config Client servisler Config Server üzerinden ayarları almaktadırlar. 

Config Server ile entegrasyonlarının yanında aynı zamanda Eureka Server'a register olurlar.   
![Servisler - 3](./images/services-3.png)


## Naming Server Eureka
`Eureka server (naming server)` kullanılabilmesi için proje oluşturulurken aşağıdaki gibi bağımlılığın eklenilmesi gerekmektedir.
![Eureka Server](./images/eureka-server-dependency.png)

Alternatif olarak maven projesi için `pom.xml` dosyasına aşağıdaki gibi `Eureka server` bağımlılığı eklenir.
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

Eureka server için eksta bir ayar yapılması gerek yoktur. Mikro servisin adının ve portunun verilmesi yeterlidir.  

```properties
spring.application.name=eureka-naming-server
server.port=8761

# Eureka server kendine register olmaması için eklendi
# By default, the registry also tries to register itself, so you need to disable that behavior as well.
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

Tabi Eureka server aktifleştirilmesi için `@EnableEurekaServer` annotation uygulamaya eklenmelidir.  
```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    // ...
}
```

## Eureka Discovery Client
Bir servisin eureka server'a register olabilmesi için `Eureka Discovery Client` bağımlılığını eklemesi gerekmektedir.

![Eureka Client](./images/eureka-discovery-client.png)

Alternatif olarak maven projesi için `pom.xml` dosyasına aşağıdaki gibi `Eureka Client` bağımlılığı eklenir.
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

Eureka server'a eklenecek olan servis `application.properties` dosyasına aşağıdaki değer eklenir. Bu işlem ile servis, eureka server'a register olur.
```properties
# EUREKA SERVER
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
```

## Cluster
Bazı servisleri farklı port numaralarında çoğaltmak için aşağıdaki ayar yapılabilir. 

Böylelikle istediğimiz kadar aynı servisten farklı portlarda çalıştırabiliriz. 

![Cluster](./images/intellij-run-configuration.png)


## Eureka Test
Eureka server'a register olan servisler [http://localhost:8761/](http://localhost:8761/) üzerinden görüntülenebilirler.

Aşağıdaki link üzerinden `currency-exchange` servisi çağrıldığında ilgili port response olarak dönecektir. Her defasında `load balancer` üzerinden farklı portlar dönülmesi beklenmektedir.

> **_UYARI:_** currency-exchange servisi içerisinden veritabanı bulundurduğundan birden fazla oluşturulması mantıklı değildir. Ancak test amacıyla şimdilik 2 ya da daha fazla oluşturulmalıdır.  
- http://localhost:8001/currency-conversion-feign/from/USD/to/TR/quantity/10 


## Kaynaklar
- https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/learn/lecture/24346958#notes
- https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html
- https://spring.io/guides/gs/service-registration-and-discovery/