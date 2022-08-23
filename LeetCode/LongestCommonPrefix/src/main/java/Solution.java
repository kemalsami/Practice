public class Solution {

    public String longestCommonPrefix(String[] strs) {


        int min = strs[0].length();
        String res = strs[0];
        for(int i=1; i<strs.length; i++){

            if(strs[i].length()==0)
                return "";

            for(int j=0; j<res.length() && j<strs[i].length();  j++){

                if( res.charAt(j)!=strs[i].charAt(j) && min>j){
                    min = j;
                    res = res.substring(0,min);
                }else if( j==strs[i].length()-1 && min>j){
                    min = j+1;
                    res = res.substring(0,min);
                }

            }

        }

        return res.substring(0,min);

    }

}
