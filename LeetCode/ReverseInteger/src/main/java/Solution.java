public class Solution {

    public int reverse(int x) {

        int result = 0;
        while(!(x/10==0 && x%10==0)){

            if(result>Integer.MAX_VALUE/10 || result<Integer.MIN_VALUE/10){
                return 0;
            }else if(result==Integer.MAX_VALUE/10 && (x%10)>Integer.MAX_VALUE%10){
                return 0;
            }else if(result==Integer.MIN_VALUE/10 && (x%10)<Integer.MIN_VALUE%10){
                return 0;
            }

            result =  ( 10 * result + (x%10));
            x=x/10;
        }

        return result;
    }

    /**
     *
     * Alternatif olarak Integer.MAX_VALUE ve Integer.MIN_VALUE son değerlerine bakmak yerine long ile karşılaştırılabilir
     *
     * result değeri long olarak tanımlanıp en sonunda int olarak cast edilmesi de alternatif çözümdür
     * 
     * @param x
     * @return
     */
    public int reverse_1(int x) {

        //long resultLong = 0;
        long result = 0;
        while(!(x/10==0 && x%10==0)){
            //resultLong = ( 10 * resultLong + (x%10));
            result =  ( 10 * result + (x%10));
            x=x/10;
        }

        //if (resultLong>Integer.MAX_VALUE || resultLong<Integer.MIN_VALUE)
        if (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE)
            return 0;

        return (int)result;
    }

}
