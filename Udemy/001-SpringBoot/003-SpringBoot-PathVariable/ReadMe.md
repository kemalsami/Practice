# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [@PathVariable](#pathvariable)
3. [Olası Hatalar](#olası-hatalar)
4. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 
 * Spring Web
 * Spring Boot DevTools

## @PathVariable
Spring üzerinde kullandığımız en temel annotation'lar aşağıdakilerdir.

- @SpringBootApplication
- @RestController
- @RequestMapping / @GetMapping
- `@PathVarible`

Spring annotation'lara baktığımızda örneğin Spring controller oluşturmak istiyorsak class başına `@RestController` yerleştirilir.

Temel Spring konfigürasyonlarını kullanmak istiyorsak bu durumda da `@SpringBootApplication` annotation konularak Spring Auto-Configuration aktifleştirilir.

Eğer bir fonksiyonu gelen request ile map etmek istiyorsak fonksiyon başına `@RequestMapping` annotation konulur.

Bunlara benzer olarak gelen istekte path üzerindeki değeri almak istiyorsak `@PathVariable` annotation kullanılır.

> ***NOT:*** Spring ile alakalı özellikleri kullanmak istiyorsak Spring annotation'lar kullanılır.

## Olası Hatalar
Spring Boot çalıştırılırken aşağıdaki hatalar ile karşılaşılabilir.

    
## Kaynaklar
- https://spring.io/projects/spring-boot

