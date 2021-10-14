# Microservices - Spring Cloud 

## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Uygulama Mimarisi](#uygulama-mimarisi)
3. [API-Gateway Dependency](#api-gateway-dependency)
4. [API-Gateway Usage](#api-gateway-usage)
5. [API-Gateway Routes](#api-gateway-routes)
   1. [application.properties](#appilicationproperties)
   2. [RouteLocatorBuilder & RouteLocator](#routelocatorbuilder--routelocator)
6. [Kaynaklar](#kaynaklar)

## Gereksinimler
* Java 1.8
* Spring Boot 2.5.5


## Uygulama Mimarisi
Uyguluma mimarisine bakıldığında tüm servislerin `Eureka Server & Config Server`'a bağlı olduğu görülür.  

Daha önce bahsedildiği gibi,
- Eureka Server, servislerin birbirlerini isim (spring.application.name) ile tanımasını sağlar.
- Config Server ile tüm servislerin application.properties dosyalarının yönetilmesi sağlanır. 
- `API-Gateway` servisi ise gelen isteklerin ilgili servislere (Eureka Server yardımıyla) yönlendirilmesini sağlar.  

![Servisler-1](./images/services-1.png)

`API-GATEWAY` servisi ile otomatik olarak Eureka üzerinden `load balancer` özelliği sağlanmaktadır.


## API-Gateway Dependency
API-Gateway kullanılabilmesi için proje oluşturulurken aşağıdaki gibi bağımlılığın eklenilmesi gerekmektedir.
![API-Gateway Dependency](./images/api-gateway-dependency.png)

Alternatif olarak maven projesi için `pom.xml` dosyasına aşağıdaki gibi `API-Gateway` bağımlılığı eklenir.
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

`API-Gateway` aktifleştirilmesi için application.properties dosyası içerisine aşağıdaki değer eklenmelidir.
```properties
# SPRING CLOUD
spring.cloud.gateway.discovery.locator.enabled=true
```

??? spring.cloud.gateway.discovery.locator.enabled açıklanacak


## API-Gateway Usage
API-Gateway servisi Eureka Server'a register olduktan sonra Eureka arayüzünde aşağıdaki gibi görülmektedir. (Instances currently registered with Eureka)

![API-Gateway Usage](./images/eureka-ui.png)

API-Gateway üzerinden bir servis `localhost:8765/{spring.application.name}/...` formatında çağrılır.

_Örnek_ olarak aşağıdaki servislerden `CURRENCY-EXCHANGE-SERVICE` direk çağrılırken aynı servis `API-GATEWAY` üzerinden çağrılması bir altındaki linkteki gibidir.
- CURRENCY-EXCHANGE-SERVICE >> [http://localhost:8101/currency-exchange/from/USD/to/TR](http://localhost:8101/currency-exchange/from/USD/to/TR) 
- API-GATEWAY >> [http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/USD/to/TR](http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/USD/to/TR)


## API-Gateway Routes


**_Soru:_**  
Neden API-Gateway routes'a ihtiyaç duyulur?

**_Cevap:_**  
API-Gateway üzerinden çağrılan servislerin URL'leri gereğinden fazla uzun ve tekrar eden yapıdadır. (`/CURRENCY-EXCHANGE-SERVICE/currency-exchange/...` gibi) Bu url yapısının kullanıcı dostu bir hale getirilmesine yardımcı olur.
---

API-Gateway üzerinden [http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/USD/to/TR](http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/USD/to/TR) linkte olduğu gibi mikro servislere istek atılabilmektedir. Buradaki amaç linkin daha okunabilir, kısa ve anlaşılabilir hale getirilmesidir. 

**_Eski_** - [http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/USD/to/TR](http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/USD/to/TR)   
**_Yeni_** - [http://localhost:8765/currency-exchange/from/USD/to/TR](http://localhost:8765/currency-exchange/from/USD/to/TR)


API-Gateway Routes işlemi 2 şekilde uygulanabilmektedir. 
- application.properties 
- RouteLocatorBuilder & RouteLocator 

Aşağıda verilen her iki farklı yaklaşım aynı sonucu vermektedir. 

### appilication.properties
```properties
spring.cloud.gateway.routes[0].uri=http://httpbin.org:80
spring.cloud.gateway.routes[0].predicates[0]=Path=/get
```

### RouteLocatorBuilder & RouteLocator
```java
@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder){

        // load balancer yerine comment örneğindeki gibi bir yönlendirme yapılabilir.
        return routeLocatorBuilder.routes()
               .route(p -> p.path("/get").uri("http://httpbin.org:80"))
               //.route(p -> p.path("/currency-exchange/**").uri("http://localhost:8101/"))
               .route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
               .build();
    }
}
```
`RouteLocatorBuilder` örneğinde http://localhost:8765/get olarak api-gateway üzerinden istek yapılması durumunda http://httpbin.org:80/get adresine yönlendirilecektir.


> &#9888;&#9888;&#9888; `path("/test")` olarak değiştirmemiz durumunda hata alınacaktır. Çünkü http://localhost:8765/test istekleri http://httpbin.org:80/test adreslerine yönlendirilecektir. Ancak http://httpbin.org:80/test adresi olmadığından WhiteLabel hata sayfası dönecektir.  

Sonuç olarak, `.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))` ile API-Gateway üzerine gelen `/currency-exchange/**` formatındaki istekler direk uzantılısı ile birlikte load balancer altında çalışan `currency-exchange-service` servisine (`uri("lb://currency-exchange-service")`) yönlendirilmektedir. 

Örn. API-Gateway servisi şuan localhost:8765 üzerinde çalışmaktadır. 
- http://localhost:8765/currency-exchange/abc isteği http://localhost:8101/currency-exchange/abc adresine,
- http://localhost:8765/currency-exchange/from/USD/to/TR isteği http://localhost:8101/currency-exchange/from/USD/to/TR adresine yönlendirilecektir.


## Kaynaklar
- https://cloud.spring.io/spring-cloud-gateway/multi/multi__configuration.html
- https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/
- https://spring.io/projects/spring-cloud
