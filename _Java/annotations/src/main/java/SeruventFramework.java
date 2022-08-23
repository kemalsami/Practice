
import annotations.RunMethodImmediately;
import annotations.SeruventEncapsulation;
import entity.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SeruventFramework {

    public static void run() throws InvocationTargetException, IllegalAccessException {

        Person person = new Person(1000 , "Guppy");

        // Check Person class has Annotation
        if(person.getClass().isAnnotationPresent(SeruventEncapsulation.class)){
            System.out.println("This is not SeruventEncapsulation");

        }else{
            System.out.println("This is not SeruventEncapsulation");
        }


        // @Target(ElementType.METHOD) example
        for(Method method : person.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunMethodImmediately.class)){
                int times = method.getDeclaredAnnotation(RunMethodImmediately.class).times();
                for(int i=0; i<times; i++)
                    method.invoke(person);
            }
        }

        for(Method method : Person.class.getDeclaredMethods()){
            if(method.isAnnotationPresent(RunMethodImmediately.class)){
                int times = method.getDeclaredAnnotation(RunMethodImmediately.class).times();
                for(int i=0; i<times; i++)
                    method.invoke(person);
            }
        }

    }

}
