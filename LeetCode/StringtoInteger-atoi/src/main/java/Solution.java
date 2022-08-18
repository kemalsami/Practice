public class Solution {

    public int myAtoi(String s) {

        s = s.trim();

        boolean firstChar = true;
        int multiply=1;
        long result = 0;
        int i=0;
        for(char c : s.toCharArray()){

            // Integer.MAX_VALUE length
            if(i>12)
                break;

            if(firstChar && c=='-'){
                multiply= -1;
                firstChar=false;
                continue;
            }else if(firstChar && c=='+'){
                firstChar=false;
                continue;
            }

            if(c>='0' && c<='9'){
                result = 10*result + c-'0';
            }else {
                break;
            }

            if(result!=0)
                i++;

            firstChar=false;
        }

        result = result * multiply;

        if(result>Integer.MAX_VALUE){
            result=Integer.MAX_VALUE;
        }else if(result<Integer.MIN_VALUE){
            result=Integer.MIN_VALUE;
        }

        return (int)result;
    }

}
