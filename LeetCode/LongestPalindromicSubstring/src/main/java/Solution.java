import java.util.Stack;

public class Solution {


    public String longestPalindrome(String s) {

        int fPos = 0;
        int lPos = 0;
        for(int i=0; i<s.length(); i++){

            int prev=i-1;
            for(int j=0; i-j>=0 && i+j<s.length() && s.charAt(i-j)==s.charAt(i+j); j++){
                if(lPos-fPos<2*j+1){
                    fPos = i-j;
                    lPos = i+j+1;
                }
            }

            for(int j=0; prev-j>=0 && i+j<s.length() && s.charAt(prev-j)==s.charAt(i+j); j++){
                if(lPos-fPos<(2*j+2)){
                    fPos = i-j-1;
                    lPos = i+j+1;
                }
            }
        }

        return s.length()>1 ? s.substring(fPos,lPos) : s;
    }

}
