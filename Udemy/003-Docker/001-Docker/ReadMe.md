# Microservices - Spring Cloud 

## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Kavramlar](#kavramlar)
   1. [Image](#image)
   2. [Container](#container)
3. [Docker Run OPTION](#docker-run-option)
4. [Docker Commands](#docker-commands)
5. [Kaynaklar](#kaynaklar)

## Gereksinimler
* Docker


## Kavramlar
Herhangi bir yazılım uygulaması geliştirilken sürüm kontrolü ve kaynak kod yönetimini sağlayan sistem olarak ilk akla [https://github.com/](https://github.com/) gelmektedir.
Yazılım geliştiriciler kodlarını bu sisteme atıp yine bu sistem üzerinden kod çekmeyi sağlarlar.

Benzer şekilde geliştirme ortamında sannallaştırmaya yarayan ve "container" olarak bilinen yapılar ise [https://hub.docker.com/](https://hub.docker.com/) ile çalışmaktadır.
Oluşturulan container'lar bu ortama atılıp github örneğinde olduğu gibi yine bu ortamdan çekilebilir.

[https://hub.docker.com/](https://hub.docker.com/) aynı zamanda `registry` olarak adlandırılmaktadır.

### Image
[https://hub.docker.com/](https://hub.docker.com/) üzerinde bulunan ancak çalışmayan yapılar `image` olarak adlandırılır. 
Diğer bir deyişle statik docker yapılardır.

### Container
[https://hub.docker.com/](https://hub.docker.com/) üzerinden çekilen local ortamda çalışan yapılar ise `container` olarak adlandırılır.
Diğer bir deyişle çalışan(running) docker yapılardır.

Bir `image`, birden fazla şekilde çalışarak farklı `container`'lar oluşturabilir. Bunun en temel örneği farklı portlarda çalışan container'lardır.  


## Docker Run OPTION 
Docker container oluşturulurken nasıl çalışacağının belirtilmesi için bazı parametreler kullanılmaktadır.  

- -p 5000:5000
  - Port Binding
  - İlk değer local port ikinci port ise container'ın kendi çalıştığı porttur
  - Container içerisindeki 5000 port'unun dışarıya verilmesini sağlar
- -d
  - Detached 
  - Container'ın arka planda çalışmasını sağlar 
- --restart=always
  - docker restart edilmesi durumunda container'ın otomatik olarak çalışmasını sağlar
- -m 
  - Memory alanının ayarlanmasını sağlar
  - 512m 1G gibi limitler belirlenir
- --cpu-quota 
  - kullanılacak olan CPU değerinin belirlenmesini sağlar
  

## Docker Commands

- docker search [KEYWORD]
- docker run [OPTION]
- docker logs -f [IMAGE-ID]
  - -f (gelen log'ların anlık görüntülenmesini sağlar)
- docker images
  - history [IMAGE-ID] (image hakkında tarihi bilgileri döner)
  - inspect [IMAGE-ID] (ilgili image için detaylı bilgi döner)
  - remove [IMAGE-ID] (ilgili image kaldırılmasını sağlar)
- docker container pause [CONTAINER-ID]
- docker container unpause [CONTAINER-ID]
- docker container prune (Çalışmayan tüm container'ları SİLER)
- docker container ls
  - -a (tüm çalışan ve çalışmayan tüm container'lar gösterilir)
- docker events (docker üzerinden gerçekleşen olayları listeler)
- docker stats (tüm container'ların durumlarını listeler)
- docker top [CONTAINER-ID] (ilgili container üzerinde son çalışan işlemi gösterir)


## Kaynaklar
- https://hub.docker.com/
- https://docs.docker.com/engine/reference/run/
