# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Advanced Exception Handling](#advanced-exception-handling)
3. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 * Spring Web
 * Spring Boot DevTools


## Advanced Exception Handling

@ResponseStatus kullanarak oluşturduğumuz UserNotFOundException class'ının response olarak dönmesi durumunda resimdeki değerler gelir. Spring default olarak bazı değerleri atamıştır.  

![UserNotFoundException](./images/UserNotFoundException.png)

Diyelim ki bir firmada çalışıyoruz ve tüm exception cevapları belirli bir standartta üretmek istiyoruz. Örneğin `status` yerine `status-code` gibi bir isim kullanıyoruz.

Kendimize özel standartlarda bir Exception yaratmak için `ResponseEntityExceptionHandler` class'ı ve `@ControllerAdvice` annotation'dan yararlanılır.

25.videodan devam edilecek (Exception Advance olarak yeni proje açılabilir.)



## Kaynaklar
- https://spring.io/projects/spring-boot
- https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc 
- https://www.baeldung.com/exception-handling-for-rest-with-spring

