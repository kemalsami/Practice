package tr.com.seruvent;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Main {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        // Create HashMap
        HashMap<String, Integer> stringFrequency = new HashMap<>();
        for(String s: strings){
            if(stringFrequency.containsKey(s)){
                stringFrequency.replace(s, stringFrequency.get(s)+1);
            }else{
                stringFrequency.put(s,1);
            };
        }

        List<Integer> frequency = new ArrayList<>();
        for(String q: queries){
            if(stringFrequency.containsKey(q)){
                frequency.add( stringFrequency.get(q));
            }else{
                frequency.add(0);
            }

        }
        return frequency;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/kemalsamikaraca/Desktop/abc.txt"));

        System.out.println("GETTING VALUE...");
        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println("stringsCount" + " :: " + stringsCount );

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println("queriesCount" + " :: " + queriesCount );

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        //System.out.println(strings.toString());
        //System.out.println(queries.toString());
        System.out.println("Progress will be start");

        List<Integer> res = Main.matchingStrings(strings, queries);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();

    }

}
