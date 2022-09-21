import java.util.*;

public class Solution {

    /**
     *
     * TwoSum Approach
     *
     * Array'deki herhangi bir değer için (target) seçilecek diğer 2 değerin toplamının negatif değeri olmalıdır
     *
     * Böylece soru 2sum problemine dönmektedir. Yani her eleman için 2Sum çözümüne bakılabilir.
     *
     * Örn. ilk eleman değeri 4 ise array içersinde toplamı -4 olan sayılar bulunmaya çalışılır
     *
     * a+b+c = 0
     *
     * @apiNote sort etmeden yapılmaya çalışıldığında duplicate elemanlar oluşmaktadır
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++){

            if(i>0 && nums[i]==nums[i-1])
                continue;

            int target = nums[i] * (-1);
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, Integer> mapResult = new HashMap<>();
            for(int j=i+1; j<nums.length; j++){

                if(map.containsKey(nums[j])){
                    mapResult.put(nums[j] , map.get(nums[j]));
                }
                map.put(target - nums[j] , map.getOrDefault(target - nums[j] , nums[j]));
            }

            int a = nums[i];
            mapResult.forEach((integer, integer2) -> {
                List<Integer> sums = new ArrayList<>();
                sums.add(a);
                sums.add(integer);
                sums.add(integer2);
                result.add(sums);
            });

        }

        return result;
    }

    /**
     *
     * Öncelikle nums dizini sıralanır
     * Başından(i) ve sonundan(j) ilerlenerek a+b+c=0 değerlerinin olup olmadığına bakılır
     *
     * Ancak bu yaklaşımla bazı durumlar kaçırılmaktadır yani soru O(n) de çözülememiştir.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer,Integer> numsFreq = new HashMap<>();
        HashMap<Integer,Integer> foundedList = new HashMap<>();
        for(int num : nums){
            numsFreq.put(num ,numsFreq.getOrDefault(num , 0) + 1);
        }


        if(numsFreq.getOrDefault(0 , 0)>=3){
            List<Integer> zeros = new ArrayList<>();
            zeros.add(0);
            zeros.add(0);
            zeros.add(0);
            result.add(zeros);
        }

        Arrays.sort(nums);
        int i=0, j=nums.length-1;
        while(i!=j){

            int resultInt = (nums[i]+nums[j])*(-1);
            if(numsFreq.containsKey(resultInt)){
                int r = numsFreq.get(resultInt);

                if(!((resultInt == nums[i] || resultInt == nums[j]) && r==1)){

                    int min = Math.min(nums[i],resultInt);
                    int max = Math.max(nums[j],resultInt);
                    if(!(foundedList.containsKey(min) && foundedList.get(min)==max)){
                        foundedList.put(min,max);
                        if(!(nums[i]==0 && nums[j]==0)){
                            List<Integer> l = new ArrayList<>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(resultInt);
                            result.add(l);
                        }
                    }

                }

            }

            if(Math.abs(nums[i])>Math.abs(nums[j])){
                i++;
            }else{
                j--;
            }
        }

        return result;
    }

}
