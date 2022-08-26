

# Annotations

1. [Create Custom Annotations](#create-custom-annotations)
2. [Annotation Parameters](#annotation-parameters)
3. [Well-known Annotations](#well-known-annotations)
4. [References](#references)





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

## Annotation Parameters

This is the simplest way to create annotation parameters. Parameter names should be finish with `()` like function call.  
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {
    int times() default 1;
}
```

Note that, if parameter default value which is times in example is not set then it should be set in annotation call. 
In this example, if @MyCustomAnnotation called above the function then times parameter has to set. 


## Well-known Annotations 

- @SuppressWarnings
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




