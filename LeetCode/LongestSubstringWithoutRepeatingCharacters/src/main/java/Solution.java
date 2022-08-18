import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     *
     *  HashMap entrySet() used to remove left side of the longest substring
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character , Integer> hashmap = new HashMap();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hashmap.get(s.charAt(i))!=null){
                int pos = hashmap.get(s.charAt(i));

                hashmap.entrySet().removeIf(map -> map.getValue().intValue()<=pos);
            }
            hashmap.put(s.charAt(i) , i);
            count = hashmap.size()>count ? hashmap.size() : count;
        }
        return count;
    }

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_slow(String s) {

        HashMap<String , Integer> hashmap = new HashMap();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hashmap.get(""+s.charAt(i))!=null){
                count = hashmap.size()>count ? hashmap.size() : count;
                i=hashmap.get(""+s.charAt(i));
                hashmap.clear();                                                    // hashmap = new HashMap();
            }else{
                hashmap.put(""+s.charAt(i) , i);
            }
        }

        count = hashmap.size()>count ? hashmap.size() : count;

        return count;

    }

}
