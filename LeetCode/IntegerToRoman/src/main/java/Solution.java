import java.util.HashMap;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class Solution {


    /**
     *
     * 9 ms, faster than 65.09% of Java online submissions for Integer to Roman.
     *
     * @param num
     * @return
     */
    public String intToRoman_accepted_v1(int num) {

        StringBuilder stringBuilder = new StringBuilder();
        int lastNumber=-1;
        int c=1;
        while(num!=0){
            lastNumber = num%10;
            if(lastNumber>=1 && lastNumber<4){

                for(int i=0; i<lastNumber; i++){
                    if(c==1){
                        stringBuilder.insert(0,"I");
                    }else if(c==10){
                        stringBuilder.insert(0,"X");
                    }else if(c==100){
                        stringBuilder.insert(0,"C");
                    }else{
                        stringBuilder.insert(0,"M");
                    }
                }

            }else if(lastNumber==4){
                if(c==1){
                    stringBuilder.append("IV");
                }else if(c==10){
                    stringBuilder.insert(0,"XL");
                }else if(c==100){
                    stringBuilder.insert(0,"CD");
                }
            }else if(lastNumber==5){
                if(c==1){
                    stringBuilder.append("V");
                }else if(c==10){
                    stringBuilder.insert(0,"L");
                }else if(c==100){
                    stringBuilder.insert(0,"D");
                }

            }else if(lastNumber==9){
                if(c==1){
                    stringBuilder.append("IX");
                }else if(c==10){
                    stringBuilder.insert(0,"XC");
                }else if(c==100){
                    stringBuilder.insert(0,"CM");
                }

            }else if(lastNumber > 5){



                for(int i=0; i<lastNumber-5; i++){
                    if(c==1){
                        stringBuilder.insert(0,"I");
                    }else if(c==10){
                        stringBuilder.insert(0,"X");
                    }else if(c==100){
                        stringBuilder.insert(0,"C");
                    }
                }

                if(c==1){
                    stringBuilder.insert(0,"V");
                }else if(c==10){
                    stringBuilder.insert(0,"L");
                }else if(c==100){
                    stringBuilder.insert(0,"D");
                }

            }

            c = c*10;
            num /= 10;
        }

        return stringBuilder.toString();
    }

}
