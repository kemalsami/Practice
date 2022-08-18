import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        // targer - value, index
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if( hashmap.containsKey(nums[i]) ){
                res[0] = hashmap.get(nums[i]);
                res[1] = i;
                break;
            }else{
                hashmap.put(target-nums[i], i);
            }
        }

        return res;

    }

}
