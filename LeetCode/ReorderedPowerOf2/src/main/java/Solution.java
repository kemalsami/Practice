import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/reordered-power-of-2/
 */
public class Solution {

    public int findLengthOfInteger(int number){
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    /**
     *
     *
     * 1 ms, faster than 100.00% of Java online submissions for Reordered Power of 2.
     *
     *  n sayısının rakamları array içersine kaçar tane oldukları atılır
     *  Örn 1024 için [1,1,1,0,1,0,0,0,0,0] tabi 1042 ya da 1204 te aynı sonucu verecektir
     *
     *  2nin kuvvetleri üzerinde gidilirken 4 haneli sayılara gelinmesi durumunda aynı şekilde array'i çıkartılıp
     *  karşılaştırılır
     *
     *
     * @param n
     * @return
     */
    public boolean reorderedPowerOf2(int n) {

        if(n<1)
            return false;

        // n sayısının rakamlarının kaçar tane olduğu array içine atılır (daha sonra karşılaştırılmak için)
        int lengthOfInteger = 0;
        int[] freq = new int[10];
        while(n!=0){
            freq[n%10]++;
            n/=10;
            lengthOfInteger++;
        }


        int powerOfTwo=1;
        int count = 0;
        // Max integer 2 üzeri 32 olduğundan 32 yeterlidir
        for(int i=1; i<32; i++){

            // iki sayının uzunluğu eşitse array kontrolü yapılır
            if(lengthOfInteger==findLengthOfInteger(powerOfTwo)){
                int powerOfTwoTemp = powerOfTwo;
                int[] freqTwo = new int[10];
                while(powerOfTwoTemp!=0){
                    freqTwo[powerOfTwoTemp%10]++;
                    powerOfTwoTemp/=10;
                }

                if(Arrays.equals(freqTwo, freq))
                    return true;

                count++;
                if(count==4)
                    break;
            }
            powerOfTwo*=2;
        }

        return false;
    }

}
