# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Swagger](#swagger)
3. [Swagger Dependencies](#swagger-dependencies)
5. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 * Spring Web
 * Spring Boot DevTools
 * Validation
 * HATEOAS


## Swagger
REST servis kullanıcıları genel olarak aşağıdaki soruların cevaplarını beklemektedir.
- Servis url'leri neler?
- Request formatı nedir? (Accept? Accept-Language? ...)
- Response formatı nedir? (application/json, application/xml ...)
- Herhangi `validation` bulunuyor mu? (size, null, min, max, past ...)
- Herhangi bir kısıtlaması var mı?
- ...

Servis kullanıcılarının(tüketicilerinin) bu gibi sorularının cevaplanabilmesi için dökümantasyon sağlanabilir. 

Swagger ile bu gibi bilgilerin güncel olarak kolay şekilde sunulması sağlanır.  


## Swagger Dependencies
Proje oluştururken Swagger bağımlılıkları otomatik olarak gelmediğinden `pom.xml` içerisine aşağıdaki bağımlılığın eklenmesi gerekir.

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.10</version>
</dependency>
```


## SWAGGER UI
Spring projesine bağımlılık eklendikten sonra `/swagger-ui.html` (localhost:8080/swagger-ui.html) ile swagger sayfasına ulaşılabilir. 

Otomatik olarak oluşturduğumuz REST sayfaları gelecektir. 


## Kaynaklar
- https://spring.io/projects/spring-boot
- https://swagger.io/specification/
- https://springdoc.org/
