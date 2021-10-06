# Spring Boot - Java 8 Example

## İçindekiler

1. [Gereksinimler](#gereksinimler)
2. [Config Client Dependency](#config-client-dependency)
3. [Config Client](#config-client)
4. [Kaynaklar](#kaynaklar)

## Gereksinimler

* Spring Web
* Spring Boot DevTools
* Actuator
* Config Client


## Config Client Dependency
Spring projesinin microservice mimarisine uygun olması için eklenmesi gereken tek dependency `config client`'dır.

Config Client kullanılabilmesi için proje oluşturulurken aşağıdaki gibi bağımlılığın eklenilmesi gerekmektedir.

![Config Client](./images/spring-cloud-settings.png)

Alternatif olarak maven projesi için `pom.xml` dosyasına aşağıdaki gibi `Config Client` bağımlılığı eklenir.
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

## Config Client
Normal bir Spring uygulamasının ayarları `application.properties` dosyası üzerinden yapılmaktadır. Ancak çok sayıda microservice mimarisinde olan Spring uygulamalarının yönetimi için ayarların yönetilmesi gerekmektedir.

`Config Server` üzerinden ayarların çekilmesi `Config Client` ile sağlanır.


## Kaynaklar

- https://spring.io/projects/spring-cloud
- https://cloud.spring.io/spring-cloud-config/reference/html/
- https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_client.html
- https://www.baeldung.com/spring-cloud-configuration