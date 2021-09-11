# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [@Component](#component)
3. [@Autowired](#autowired)
4. [JACKSON](#jackson)
5. [JACKSON Setting](#jackson-settings)
6. [Olası Hatalar](#olası-hatalar)
7. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 * Spring Web
 * Spring Boot DevTools


## @Component
UserService class'ta `@Component` annotation kullanılmıştır. `@Autowired` kullanılabilmesi için gerekli olduğundan eklenmiştir.


## @Autowired
Bu annotation ile bir obje oluşturduğumuzda `new` ile başlayan Constructor seçmemize gerek kalmaz. Otomatik olarak uygun olan contructor ile obje yaratılır.


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

