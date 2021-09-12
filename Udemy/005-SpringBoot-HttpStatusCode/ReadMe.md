# Spring Boot - Java 8 Example


## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [HTTP Status Code](#http-status-code)
3. [Kaynaklar](#kaynaklar)
	

## Gereksinimler
 * Spring Web
 * Spring Boot DevTools


## HTTP Status Code
Bazen isteklere dönerken HTTP durumlarını farklı dönmek gerekebilir.

- 1xx informational response – the request was received, continuing process
- 2xx successful – the request was successfully received, understood, and accepted
- 3xx redirection – further action needs to be taken in order to complete the request
- 4xx client error – the request contains bad syntax or cannot be fulfilled
- 5xx server error – the server failed to fulfil an apparently valid request


## ResponseEntity
Gelen isteklerin `http status code` değerleri ile dönülmesi ResponseEntity ile sağlanır.

Örneğin bir post işleminde response olarak herhangi bir değer dönülmesine gerek yoktur. İşlemin gerçekleştirilip gerçekleştirilmediği hakkında bir bilgi verilmesi yeterli olacaktır. 

> Response header status code değerine dikkat edilmedi gerekir.  
> 
> Örn. ResponseEntity.created() ile `201` durum kodu dönerken ResponseEntity.ok() ile `200` durum kodu dönmektedir.


## Kaynaklar
- https://spring.io/projects/spring-boot
- https://en.wikipedia.org/wiki/List_of_HTTP_status_codes

