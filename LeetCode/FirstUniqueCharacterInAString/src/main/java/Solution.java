import java.util.*;

public class Solution {


    public int firstUniqChar(String s) {

        // 97 - 122 ASCII
        int[] table = new int[26];
        int[] count = new int[26];
        int result=Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int a = ch - 97;
            table[a] = i;
            count[a] = count[a]+1;
        }

        for(int i=0; i<26; i++){
            if(count[i]==1 && result>table[i]){
                result=table[i];
            }
        }

        return result==Integer.MAX_VALUE? -1 : result;

    }

    /**
     *
     * Accepted but faster than %30
     *
     * @param s
     * @return
     */
    public int firstUniqChar_accepted_v1(String s) {

        // 97 - 122 ASCII
        int[] table = new int[26];
        int[] count = new int[26];
        Arrays.fill(table, -1);
        int a=-1;
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        Queue<Character> queue = new PriorityQueue<>();
        List<Character> list = new ArrayList<>();

        int result=-1;
        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);
            if(hashmap.getOrDefault(ch , 0)==0){
                queue.add(ch);
                list.add(ch);
                hashmap.put(ch,1);
                a = ch - 97;
                table[a] = i;
            }else{
                hashmap.put(ch, hashmap.get(ch) + 1);
            }

        }

        for(int i=0; i<list.size(); i++){
            char next = list.get(i);
            if(hashmap.getOrDefault(next , 0)==1){
                a = next-97;
                result=table[a];
                break;
            }
        }

        /*
        while(!queue.isEmpty()){
            char next = queue.remove();
            if(hashmap.getOrDefault(next , 0)==1){
                a = next-97;
                result=table[a];
                break;
            }
        }
         */


        return result;

    }

}
