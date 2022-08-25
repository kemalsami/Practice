import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     *
     * 14 ms, faster than 51.96% of Java online submissions for Ransom Note.
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character,Integer> charMap = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            charMap.put(magazine.charAt(i), charMap.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(int i=0; i<ransomNote.length(); i++){
            charMap.put(ransomNote.charAt(i), charMap.getOrDefault(ransomNote.charAt(i),0)-1);
            if(charMap.get(ransomNote.charAt(i))<0){
                return false;
            }
        }

        return true;
    }

}
