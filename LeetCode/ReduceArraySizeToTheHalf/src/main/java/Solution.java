import java.util.*;

/**
 * TODO: https://leetcode.com/problems/reduce-array-size-to-the-half/
 */
public class Solution {

    /**
     *
     * Çözüme bakıldı!!!
     *
     * DP'de olduğu gibi sonuçlar farklı bir array içersinde atıldı.
     *      Array index'leri bir sayının kaç tane olduğunu göstermektedir
     *      Array index'indeki değerde ise kaçar tane olduğu belirtilmektedir
     *
     * @param arr
     * @return
     */
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) cnt.put(x, cnt.getOrDefault(x, 0) + 1);

        int[] counting = new int[n + 1];
        for (int freq : cnt.values()) ++counting[freq];

        int ans = 0, removed = 0, half = n / 2, freq = n;
        while (removed < half) {
            ans += 1;
            while (counting[freq] == 0) --freq;
            removed += freq;
            --counting[freq];
        }
        return ans;
    }


    /**
     *
     * Bir önceki çözüme ek olarak tree yerine array içersine değerler konularak sort edilir.
     *
     * sort işlemi n*logn olduğundan süre biraz uzun olmaktadır
     *
     * @param arr
     * @return
     */
    public int minSetSize_accepted_v2(int[] arr) {

        int arrLength = arr.length/2;
        int result=0;
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int a : arr){
            hashMap.put(a , hashMap.getOrDefault(a, 0)+1);
        }

        int[] frequencies = new int[hashMap.size()];
        int i=0;
        for(int values : hashMap.values()){
            frequencies[i] = values;
            i++;
        }

        Arrays.sort(frequencies);

        i=1;
        for(int j=frequencies.length-1; j>=0; j-- ){

            result+=frequencies[j];
            if(result>=arrLength)
                return i;

            i++;
        }


        return -1;
    }


    /**
     * Array içinde kaçar tane değer olduğu bulunur
     * Greedy algorithm ile en yüksekten başlanarak
     *
     * TreeMap içerisinde sayıların kaçar tane olduğu tutulur
     *
     * ----- ----- -----
     * Örn 3,3,3,3,5,5,5,2,2,7 baz alındığında
     *
     * Hashmap
     *      3 -> 4
     *      5 -> 2
     *      2 -> 2
     *      7 -> 1
     *
     * Treemap
     *      1 -> 1
     *      2 -> 2
     *      4 -> 1  (4 tane olan sayıların kaçar tane olduğunu belirtir)
     *
     * ----- ----- -----
     * Örn 3,3,3,3,5,5,5,2,2,7,1,1,1,1 yani sonuna 4 tane daha 1 eklenseydi
     *
     * Hashmap
     *      1 -> 4
     *      3 -> 4
     *      5 -> 2
     *      2 -> 2
     *      7 -> 1
     *
     * Treemap
     *      1 -> 1
     *      2 -> 2
     *      4 -> 2  (4 tane olan sayıların değeri 2 olacaktı)
     *
     *
     * @param arr
     * @return
     */
    public int minSetSize_accepted_v1(int[] arr) {

        int arrLength = arr.length/2;
        HashMap<Integer, Integer> hashMap = new HashMap();
        TreeMap<Integer, Integer> ts = new TreeMap<>();
        for(int a : arr){
            int integerCount = hashMap.getOrDefault(a, 0)+1;
            hashMap.put(a , integerCount);

            //
            ts.put(integerCount , ts.getOrDefault(integerCount , 0)+1);
            ts.put(integerCount-1 , ts.getOrDefault(integerCount-1 , 0)-1);
        }

        int result=0;
        int i=0;
        while(ts!=null){

            Map.Entry<Integer, Integer> entry =  ts.pollLastEntry();
            int val = entry.getKey();
            int count = entry.getValue();

            // we can improve
            /*
            int diff = arrLength - result; // diff=4 & val=1 & count=1
            if(diff/val>=count){
                i+=count;
                result += count * val;
            }else{
                i+=Math.ceil((double)diff/val);
                result += diff;
            }

             */


            while(result<arrLength && count>0){
                result+=val;
                i++;
                count--;
            }


            if(result>=arrLength)
                return i;

        }

        return -1;
    }

}
