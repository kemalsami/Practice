import java.util.HashSet;
import java.util.Set;

/**
 *
 * TODO: https://leetcode.com/problems/unique-morse-code-words/submissions/
 *
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {

        Set<String> transformation = new HashSet<>();
        String[] chars = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word: words){

            StringBuilder stringBilder = new StringBuilder("");

            for(int i=0; i< word.length(); i++){
                char c = word.charAt(i);
                int x = c-97;
                stringBilder.append(chars[x]);
            }

            transformation.add(stringBilder.toString());

        }

        return transformation.size();
    }

}
