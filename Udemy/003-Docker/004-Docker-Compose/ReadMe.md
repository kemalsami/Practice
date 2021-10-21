# Microservices - Spring Cloud 

## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Docker Compose](#docker-compose)
3. [Kaynaklar](#kaynaklar)

## Gereksinimler
* Java 1.8
* Spring Boot 2.5.5


## Docker Compose 
Maven plugin'lerinden `spring-boot:build-image` kullanılarak spring mikro servisten docker image oluşturulur.

Mikro servisler, farklı dil ve maven, ant gibi çeşitli project management tool'ları kullandıklarından ayrı ayrı image'larının oluşturulması gerekmektedir. 

Docker container oluşturmak için docker image'ları kullanılır. Örnek uygulamada 4 tane mikro servis yani 4 farklı docker image bulunmaktadır.
- currency-exchange 
- currency-conversion
- api-gateway
- eureka-server

Docker container oluştururken her bir image için ayrı ayrı docker run komutunu çalıştırmak gerekecektir. Onun yerine `docker-compose` ile tüm run konfigürasyonları tek bir dosya içersinde belirtilebilir.

## docker-compose.yml

```yml
services:
  currency-exchange:
    image: kemalsami/currency-exchange:0.0.1-SNAPSHOT
    ports:
      - 8101:8101
```

`docker-compose.yml` dizinine gidilir ve aşağıdaki komut çalıştırılır.
```shell
docker-compose up
```

## Linkler
- 

## Kaynaklar
- https://docs.docker.com/compose/

