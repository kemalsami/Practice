package annotations;

import entity.Person;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunMethodImmediately {

    int times() default 1;

    // Invalid type 'Person' for annotation member
    //Person person();
}
