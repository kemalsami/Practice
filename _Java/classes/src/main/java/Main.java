import entity.Person;

import java.io.Serializable;

public class Main {

    public static void main(String[] args){

        /**
         *
         * Person class, Serializable interface ile işaretlenmiştir.
         *
         * Böylelikle bu sınıfın Serializable bir sınıf olduğunu bilinerek işlem yapılabilir.
         */
        Person person = new Person();
        if(person instanceof Serializable){
            System.out.println(person.getClass().getName() + " marked as Serializable");
        }else {
            System.out.println(person.getClass().getName() + " is not Serializable");
        }
    }

}
