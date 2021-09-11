
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args){
        System.out.println("***************************");
        System.out.println("Unscrambl Coding Assignment");
        System.out.println("***************************");

        // Read intervals from file
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File myObj = new File("src/main/resources/intervals.txt");
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        // Adding intervals to Histogram
        Histogram histogram = new Histogram(stringBuilder.toString());


        // Test histogram with random new values
        Random random = new Random();
        for(int i=0; i<1000; i++){
            double rand = random.nextInt(50) + (random.nextInt(100)/100.0);


            histogram.insert(rand);
            Thread thread = new Thread() {
                public void run()
                {
                    histogram.insert(rand);
                }
            };
            thread.start();
        }

        histogram.printHistogram();

    }
}
