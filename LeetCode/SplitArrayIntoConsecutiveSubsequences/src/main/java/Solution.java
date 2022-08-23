import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 */
public class Solution {


    public boolean isPossible(int[] nums) {

        if(nums.length<3)
            return false;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hashMap.put(nums[i] , hashMap.getOrDefault(nums[i] , 0)+1);
        }


        int prev = nums[0];
        int freq1,freq2,freq3;
        int[] freq = new int[3];
        //int freq1 = hashMap.getOrDefault(nums[i%3] , 0);
        //int freq2 = hashMap.getOrDefault(nums[0] , 0) - freq1;
        //int freq3 = hashMap.getOrDefault(nums[0] , 0) - freq2;


        for(int i=0; i<nums.length; i++){


            //i elemanı için i%3 değerine bakılır

            if(prev==nums[i]){
                continue;
            }

            int x = nums[i]%3;
            if(freq[x]==0){
                freq[x] = hashMap.getOrDefault(nums[i] , 0);
            }else {
                // karşılaştırma yapılmalıdır (min değeri için)

                if(!(hashMap.getOrDefault(nums[i] , 0)>=freq[x] - freq[x-1])){
                    return false;
                }

                freq[(i%3)-1] = hashMap.getOrDefault(nums[i] , 0)-freq[i%3];
                freq[(i%3)-2] = hashMap.getOrDefault(nums[i] , 0)-freq[i%3];
                freq[i%3] = hashMap.getOrDefault(nums[i] , 0);

            }



            prev = nums[i];
        }

        return true;
    }


    public boolean isPossible_Wrong_Answer_1(int[] nums) {

        if(nums.length<3)
            return false;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=0; i<nums.length; i++){
            hashMap.put(nums[i] , hashMap.getOrDefault(nums[i] , 0)+1);

            if(list.get(list.size()-1)!=nums[i]){
                list.add(nums[i]);
            }
        }

        HashMap<Integer , Integer> subsequenceMap = new HashMap<>();
        for(int i=0; i<list.size()-2; i++){

            int key=list.get(i);
            int value = hashMap.getOrDefault(key,0);
            if(value==0 || hashMap.getOrDefault(key+1,0)<value || hashMap.getOrDefault(key+2,0)<value){
                continue;
            }

            if(hashMap.getOrDefault(key+1,0)==value){
                hashMap.remove(key+1);
            }else{
                hashMap.put(key+1 ,hashMap.getOrDefault(key+1,0) - value );
            }

            if(hashMap.getOrDefault(key+2,0)==value){
                hashMap.remove(key+2);
            }else{
                hashMap.put(key+2 ,hashMap.getOrDefault(key+2,0) - value );
            }

            hashMap.remove(key);
            subsequenceMap.put(key+2, value);
        };

        for(int i=0; i<list.size(); i++){
            int key=list.get(i);
            int value = hashMap.getOrDefault(key,0);
            if(value==0)
                continue;

            if(subsequenceMap.getOrDefault(key-1, 0)<value){
                return false;
            }else{
                subsequenceMap.put(key,value);
                subsequenceMap.put(key-1,subsequenceMap.getOrDefault(key-1, 0) - value);
            }
        }


        return true;
    }

}
