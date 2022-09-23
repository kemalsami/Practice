import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> numbers = new HashMap<>();
        numbers.put('2' , Arrays.asList(new String[]{"a","b","c"}));
        numbers.put('3' , Arrays.asList(new String[]{"d","e","f"}));
        numbers.put('4' , Arrays.asList(new String[]{"g","h","i"}));
        numbers.put('5' , Arrays.asList(new String[]{"j","k","l"}));
        numbers.put('6' , Arrays.asList(new String[]{"m","n","o"}));
        numbers.put('7' , Arrays.asList(new String[]{"p","q","r","s"}));
        numbers.put('8' , Arrays.asList(new String[]{"t","u","v"}));
        numbers.put('9' , Arrays.asList(new String[]{"w","x","y","z"}));
        Queue<String> queue = new LinkedList<>();

        String str="";
        for(int i=0; i<digits.length(); i++){
            while (queue.size()==0 || str.length()==i) {
                str = queue.size()!=0 ? queue.poll() : "";
                for(String c : numbers.get(digits.charAt(i))){
                    queue.add(str+c);
                }
                str = queue.peek();
            }
        }

        return (List)queue;
    }



    public List<String> letterCombinations_1(String digits) {
        Map<Character, List<String>> numbers = new HashMap<>();
        numbers.put('2' , Arrays.asList(new String[]{"a","b","c"}));
        numbers.put('3' , Arrays.asList(new String[]{"d","e","f"}));
        numbers.put('4' , Arrays.asList(new String[]{"g","h","i"}));
        numbers.put('5' , Arrays.asList(new String[]{"j","k","l"}));
        numbers.put('6' , Arrays.asList(new String[]{"m","n","o"}));
        numbers.put('7' , Arrays.asList(new String[]{"p","q","r","s"}));
        numbers.put('8' , Arrays.asList(new String[]{"t","u","v"}));
        numbers.put('9' , Arrays.asList(new String[]{"w","x","y","z"}));
        List<String> result_1 = new ArrayList<>();
        List<String> result_2 = new ArrayList<>();
        List<String> cloned_list;

        for(int i=0; i<digits.length(); i++){

            result_2 = new ArrayList<>();
            if(i==0){
                for(String c : numbers.get(digits.charAt(i))){
                    result_1.add(c);
                }
            }else{
                for(String str : result_1){
                    for(String c : numbers.get(digits.charAt(i))){
                        result_2.add(str+c);
                    }
                }
                result_1 = new ArrayList<>(result_2);
            }
        }

        return result_1;
    }

}
