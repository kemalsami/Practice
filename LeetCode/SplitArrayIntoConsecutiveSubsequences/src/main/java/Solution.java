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

        HashMap<Integer, Integer> hashmap = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length ;i++){
            hashmap.put(nums[i] , hashmap.getOrDefault(nums[i] , 0)+1);
        }


        List<int[]> list = new ArrayList<>();
        int[] a = new int[3];
        a[0] = nums[0];
        a[1] = 1;//hashmap.getOrDefault(nums[0], 0);
        a[2] = 1;
        list.add(a);
        for(int j=1; j<nums.length; j++){


        }

        return true;
    }

    /**
     *
     * 582 ms, faster than 5.23% of Java online submissions for Split Array into Consecutive Subsequences.
     *
     *
     *
     * @param nums
     * @return
     */
    public boolean isPossible_accepted_v1(int[] nums) {

        if(nums.length<3)
            return false;

        List<ArrayList<Integer>> sequenceList = new LinkedList<>();
        ArrayList list = new ArrayList();
        list.add(nums[0]);
        sequenceList.add(list);
        for(int i=1; i<nums.length; i++){
            boolean flag=false;
            x:
            for(int j=sequenceList.size()-1 ; j>=0; j--){

                if(sequenceList.get(j).get(sequenceList.get(j).size()-1)<nums[i]-1){
                    ArrayList temp = new ArrayList();
                    temp.add(nums[i]);
                    sequenceList.add(temp);
                    flag=true;
                    break x;
                }

                if(sequenceList.get(j).get(sequenceList.get(j).size()-1)==nums[i]-1) {
                    sequenceList.get(j).add(nums[i]);
                    flag=true;
                    break x;
                }
            }

            if(!flag){
                ArrayList temp = new ArrayList();
                temp.add(nums[i]);
                sequenceList.add(temp);
            }

        }

        for(int n=0; n<sequenceList.size(); n++){
            if(sequenceList.get(n).size()<3)
                return false;
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
