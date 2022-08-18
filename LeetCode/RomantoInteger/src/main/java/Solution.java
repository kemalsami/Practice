import java.util.HashMap;

public class Solution {


    public int romanToInt(String s) {

        int result=0;
        int prev=0;
        int temp=0;
        HashMap<Character, Integer> map= new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        for(int i=0; i<s.length(); i++){

            int val=map.get(s.charAt(i));

            if(prev==0 || prev>=val){
                if(prev>val){
                    result+=temp;
                    temp=0;
                }
                temp=val+temp;
            }else if(prev<val){
                temp=val-temp;
                result+=temp;
                temp=0;
            }

            if(i+1==s.length())
                result += temp;

            prev = val;
        }

        return result;
    }

}
