# Microservices - Spring Cloud 

## İçindekiler
1. [Gereksinimler](#gereksinimler)
2. [Container Orchestration](#container-orchestration)
   1. [Container Orchestration tipik özellikleri](#container-orchestration-tipik-zellikleri)
   2. [Container Orchestration opsiyonları](#container-orchestration-opsiyonlar)
3. [Kaynaklar](#kaynaklar)

## Gereksinimler
* Java 1.8
* Spring Boot 2.5.5


## Container Orchestration
Docker ile mikro servislerin oluşturulması ve uygun ortamlarda çalıştırılması sağlanır. Docker Container sayının artması durumunda bunların yönetilmesi ihtiyacı doğmuştur.

#### Container Orchestration tipik özellikleri
- **_Auto Scaling_** - ihtiyaca göre container'ların arttırılıp azaltılmasını sağlamalı
- **_Service Discovery_** - servislerin birbirlerini bulabilmesi sağlanmalı
- **_Load Balancer_** - yükün mikro servisler üzerinde dağılımını sağlamalı
- **_Self Healing_** - servislerin durumlarının kontrol edilmesi ve gerekirse yenisinin oluşturulmasını sağlamalı
- **_Zero Downtime Deployments_** - release durumunda uygulamanın akıcı şekilde güncellenmesini sağlamalı

#### Container Orchestration opsiyonları:
- AWS Specific
  - AWS Elastic Container Service (ECS)
  - AWS Fargate : Serverless version of AWS ECS
- Cloud Neutral - Kubernetes
  - AWS - Elastic Kubernetes Service (EKS)
  - Azure - Azure Kubernetes Service (AKS)
  - GCP - Google Kubernetes Engine (GKE) ** free ** 

## Kaynaklar
- https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/learn/lecture/24346614

