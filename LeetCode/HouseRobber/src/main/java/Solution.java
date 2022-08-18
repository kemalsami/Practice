import java.util.HashMap;

public class Solution {

    private HashMap<Integer, Integer> hashmap = new HashMap<>();

    /**
     * {a1,a2,a3,a4,a5,... ,ai,  ... an}
     *
     * we know that if a number selected then next number cannot be adjacent number
     * if ai selected then a(i-1) and a(i+1) cannot be selected
     *
     * which mean that if you start with a1 then next move can be any number except a2
     *
     * **
     *  Sonuç olarak aslında soru fibonacci serisine benzemektedir. Seçilen herhangi bir i noktası için aslında i-2 veya
     *  i-3 üzerinden gelebilmektedir. Yani i-2 ya da i-3'e kadar gelen evler üzerinden hangisinin fazlaysa o seçilerek
     *  devam edilir
     * **
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        int[] sum = new int[nums.length];

        if(nums.length==1){
            return nums[0];
        }

        if(nums.length==2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = nums[2]+sum[0];
        if(nums.length==3){
            return sum[2] > sum[1] ? sum[2] : sum[1];
        }

        for(int i=3; i<nums.length; i++){
            sum[i] = nums[i] + (sum[i-2] > sum[i-3] ? sum[i-2] : sum[i-3] );
        }

        return sum[nums.length-1] > sum[nums.length-2] ? sum[nums.length-1] : sum[nums.length-2];
    }

}
