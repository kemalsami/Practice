# Microservices - Spring Cloud 

## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Docker Create Image](#docker-create-image)
   1. [spring-boot:build-image](#spring-bootbuild-image)
3. [Docker Create Container](#docker-create-image)
4. [Kaynaklar](#kaynaklar)

## Gereksinimler
* Java 1.8
* Spring Boot 2.5.5


## Docker Create Image
Spring üzerinde yazdığımız mikro servisinden docker container oluşturulabilmesi için maven plugin (`spring-boot-maven-plugin`) kullanılmaktadır. 
Spring mikro servis oluştururken maven kullandığımızdan otomatik olarak plugin gelmektedir. 

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <image>
                    <name>seruvent/${project.artifactId}:${project.version}</name>
                </image>
                <pullPolicy>IF_NOT_PRESENT</pullPolicy>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Görüldüğü üzere `spring-boot-maven-plugin` altında `configuration` tanımlanmıştır. Oluşturulacak image ismi configuration altında tanımlanmalıdır.

#### spring-boot:build-image
pom.xml üzerinde ilgili değişiklikler yapıldıktan sonra `spring-boot:build-image` işi çalıştırılır. Bu işlem biraz zaman alabilir. 

Image oluşturma logları aşağıdaki gibidir. `docker.io/kemalsami/currency-exchange:0.0.1-SNAPSHOT` üzerinde image oluşturulmuştur.
```
...
[INFO]     [creator]     Adding label 'org.opencontainers.image.version'
[INFO]     [creator]     Adding label 'org.springframework.boot.version'
[INFO]     [creator]     Setting default process type 'web'
[INFO]     [creator]     Saving docker.io/kemalsami/currency-exchange:0.0.1-SNAPSHOT...
[INFO]     [creator]     *** Images (4ed4ff72d400):
[INFO]     [creator]           docker.io/kemalsami/currency-exchange:0.0.1-SNAPSHOT
[INFO] 
[INFO] Successfully built image 'docker.io/kemalsami/currency-exchange:0.0.1-SNAPSHOT'
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  37.754 s
[INFO] Finished at: 2021-10-20T21:30:44+03:00
[INFO] ------------------------------------------------------------------------
```

İşlem sonunda oluşan docker image'ı görüntülemek için docker komutu çalıştırılabilir.
```shell
docker images
```

## Docker Create Container
Docker image oluşturulduktan container oluşturularak mikro servisin ayağa kalkması sağlanır.

```shell
docker run --name currency-exchange -p 8101:8101 -d kemalsami/currency-exchange:0.0.1-SNAPSHOT
```

`docker run` işleminden sonra currency-exchange container oluşmuş ve çalışmaya başlamıştır.

## Linkler 
- http://localhost:8101/currency-exchange/from/USD/to/TRY


## Kaynaklar
- https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/learn/lecture/24346750
- https://spring.io/projects/spring-cloud

