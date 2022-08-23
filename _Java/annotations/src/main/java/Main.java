import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args){

        System.out.println("Example annotations");

        try {

            SeruventFramework.run();

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
