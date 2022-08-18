import java.util.HashMap;

/**
 *  https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Main {

    public static void main(String[] args){
        String str;
        int l;
        Solution solution = new Solution();

        HashMap<String , Integer> s = new HashMap<>();
        s.put("kemal", 1);
        System.out.println(s.get("kemal"));
        s.put("kemal" , 2);
        System.out.println(s.get("kemal"));

        str = "abcabcbb";
        l = solution.lengthOfLongestSubstring(str);
        System.out.println("Length of " + str + " is -> " + l);


        str = "bbbbb";
        l = solution.lengthOfLongestSubstring(str);
        System.out.println("Length of " + str + " is -> " + l);


        str = "pwapk";
        l = solution.lengthOfLongestSubstring(str);
        System.out.println("Length of " + str + " is -> " + l);


        str = "abcdecfgh";
        l = solution.lengthOfLongestSubstring(str);
        System.out.println("Length of " + str + " is -> " + l);

    }
}
