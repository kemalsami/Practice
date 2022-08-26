

# Annotations

1. [Create Custom Annotations](#create-custom-annotations)
2. [Well-known Annotations](#well-known-annotations)
3. [References](#references)





## Create Custom Annotations

This is the simplest way to create annotations. 
```java
public @interface Seruvent {
}
```

To customize the annotations you are going to be using some other annotations such as `target`, `retention` etc.
```java
import java.lang.annotation.Target;

@Target   
public @interface Seruvent {
}
```

## Well-known Annotations 

- @Autowired
- @Qualifier
- @Configuration
- @Required
- @SpringBootApplication
  - @SpringBootApplication is a combination of @Configuration, @EnableAutoConfiguration and @ComponentScan
  - @SpringBootApplication scans all the components or services and other configuration files included in the base and child packages

## References 

- https://www.youtube.com/watch?v=DkZr7_c9ry8
- https://www.geeksforgeeks.org/spring-autowired-annotation/




