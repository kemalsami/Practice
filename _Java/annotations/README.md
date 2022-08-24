

# Annotations

1. [Create Custom Annotations](#create-custom-annotations)
2. 





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






