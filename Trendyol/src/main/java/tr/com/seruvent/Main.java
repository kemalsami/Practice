package tr.com.seruvent;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

    /*
        int[] x = {1, 3, 6, 4, 1, 2};
        int res = solution(x);
        System.out.println(res);
     */

    /*
        int[] x = {1, 3, 6, 4, 1, 2};
        int res = solution(x);
        System.out.println(res);
    */

        String number = "022";
        int res = solution(number);
        System.out.println(res);
    }



    public static int solution(String S) {

        boolean flag=false;
        int result = 0;
        for(int i=0; i<S.length(); i++){
            String newNumber;
            if(i==0){
                newNumber = S.substring(i+1);
            }else{
                newNumber = S.substring(0,i) + S.substring(i+1);
            }

            int num = Integer.parseInt(S.substring(i,i+1));
            switch (Integer.parseInt(newNumber) % 3){
                case 0:
                    result += 4;
                    if(num==0 || num==3 || num==6 || num==9){
                        flag=true;
                        result--;
                    }
                    break;
                case 1:
                    result += 3;
                    if(num==2 || num==5 || num==8){
                        flag=true;
                        result--;
                    }
                    break;
                case 2:
                    result += 3;
                    if(num==1 || num==4 || num==7){
                        flag=true;
                        result--;
                    }
                    break;
                default:
                    break;
            }
        }

        if(flag)
            result++;

        return result;
    }


    public static int solution2(int[] A) {
        // write your code in Java SE 8
        int sign = 1;
        for(int i=0; i<A.length; i++){
            if(A[i]==0){
                return 0;
            }else if(A[i]<0){
                sign *= -1;
            }
        }
        return sign;
    }

    public static int solution1(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);

        int index=1;
        for(int i=0; i<A.length; i++){
            if(A[i] > 0){

                if(A[i]==index-1){
                    continue;
                }else if( A[i]==index){
                    index++;
                    continue;
                }
                break;
            }
        }

        return index;
    }
}
