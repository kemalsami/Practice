import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class Solution {


    /**
     * Array sıralanır
     *
     * Her karakter için soldan ve sağdan değerler alınarak target değerine yaklaşılmaya çalışılır
     *
     * j değeri baştan k değeri ise listenin sonundan başlar.
     *  nums[i]+nums[j]+nums[k] < target ise j değeri arttılarak target değerine yaklaşmaya çalışılır
     *  nums[i]+nums[j]+nums[k] > target ise k değeri azaltılarak target değerine yaklaşmaya çalışılır
     *  j == k olması durumunda ise bir sonraki sayıya geçilerek aynı işlemler tekrarlanır
     *
     */
    public int threeSumClosest(int[] nums, int target) {

        int resultSum = nums[0]+nums[1]+nums[2];
        if(resultSum==target)
            return target;

        Arrays.sort(nums);
        int minDiff = Math.abs(resultSum-target);
        int size = nums.length;
        for(int i=0; i<size-2; i++){

            int k = size-1;
            int j = i+1;
            while(j<k){

                int currentSum = nums[i] + nums[j] + nums[k];
                if(currentSum==target)
                    return target;

                if(Math.abs(currentSum - target) < minDiff){
                    resultSum = currentSum;
                    minDiff = Math.abs(resultSum - target);
                }

                if(currentSum > target){
                    k--;
                }else if(currentSum < target){
                    j++;
                }

            }
        }

        return resultSum;
    }

    /**
     *
     * Bu çözümde a ve b değeri toplamı için c değeri üzerinden hesaplama yapılır.
     *
     * Min(a + b + c - target) için c değerinin düzgün seçilmesi gerekmektedir. "a + b - target" işleminden sonra
     * treeset üzerinden ceiling ve floor değerlerine bakılarak c değeri seçilir.
     *
     * Seçilen c değeri için fark azalıyorsa minDiff değeri güncellenerek en az farklı toplam seçilmiş olur.
     *
     * Min(a + b + c - target)
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest_version_2(int[] nums, int target) {

        int result = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashMap<Integer, Integer> freq  = new HashMap<>();
        for(int num : nums){
            treeSet.add(num);
        }

        for(int i=0; i<nums.length; i++){
            freq.put(nums[i] , freq.getOrDefault(nums[i] , 0) + 1);
        }

        for(int i=0 ; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){


                int a = nums[i];
                int b = nums[j];
                int sum = a + b; // a + b
                int minFreqCount = (a == b) ? 2 : 1;

                // try to find c in tree
                Integer ceil;
                int closestNumber = target - sum;
                do {
                    ceil = treeSet.ceiling(closestNumber);
                    if(ceil==null)
                        break;

                    if(ceil.intValue() == a || ceil.intValue() == b){
                        if(freq.getOrDefault(ceil.intValue(), 0) <= minFreqCount){
                            closestNumber = ceil + 1;
                        }
                    }

                }while(closestNumber==ceil+1);


                Integer floor;
                closestNumber = target - sum;
                do {
                    floor = treeSet.floor(closestNumber);
                    if(floor==null)
                        break;

                    if(floor.intValue() == a || floor.intValue() == b){
                        if(freq.getOrDefault(floor.intValue(), 0) <= minFreqCount){
                            closestNumber = floor - 1;
                        }
                    }

                }while(closestNumber==floor-1);

                if(ceil!=null && floor!=null){
                    Integer c = Math.abs(sum+ceil - target) < Math.abs(sum+floor - target) ? ceil : floor;
                    sum = sum + c;
                    int diff = Math.abs(sum - target);
                    if( diff < minDiff ){
                        result = sum;
                        minDiff = diff;
                    }
                }else if (ceil==null){
                    Integer c = floor;
                    sum = sum + c;
                    int diff = Math.abs(sum - target);
                    if( diff < minDiff ){
                        result = sum;
                        minDiff = diff;
                    }
                }else if(floor==null){
                    Integer c = ceil;
                    sum = sum + c;
                    int diff = Math.abs(sum - target);
                    if( diff < minDiff ){
                        result = sum;
                        minDiff = diff;
                    }
                }

            }
        }

        return result;
    }


    /**
     *
     * Dummy solution O(n^3)
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest_version_1(int[] nums, int target) {

        int result = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff =  Math.abs(sum - target);
                    if( diff < minDiff ){
                        result = sum;
                        minDiff = diff;
                    }

                }
            }
        }

        return result;
    }

}
