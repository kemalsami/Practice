public class Solution {

    /**
     *
     *
     * TODO: https://leetcode.com/problems/container-with-most-water/submissions/
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int i=0;
        int j=height.length-1;
        int result = 0;
        while(i!=j){
            int area = Math.min(height[i], height[j]) * Math.abs(i-j);
            result = result < area ? area : result;
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }


        return result;
    }


    /**
     *
     *  1,8,6,2,5,4,8,3,7
     *  i               j
     *
     * Herhangi bir nokta için maksimum alan değeri kendisinden büyük olan en uzak değer içindir
     *
     * Bu sebepten i array başından ve j array sonundan olmak üzere başlanır. Küçük olan değer için i ya da j kaydırılır
     *
     * TODO: SLOW
     * Runtime: 7 ms, faster than 19.73% of Java online submissions for Container With Most Water.
     *
     * @param height
     * @return
     */
    public int maxArea_accepted_v2(int[] height) {

        int i=0;
        int j=height.length-1;
        int result = 0;
        while(i!=j){
            int area = Math.min(height[i], height[j]) * Math.abs(i-j);
            result = result < area ? area : result;
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }


        return result;
    }




    /**
     *
     * Brute force method O(n*n)
     *      MIN(a[i]-a[j]) * abs(i-j)
     *
     * @param height
     * @return
     */
    public int maxArea_accepted_v1(int[] height) {

        int result=0;
        for(int i=0; i<height.length; i++){
            for(int j=0; j<height.length; j++){
                int loc = Math.min(height[i], height[j]) * Math.abs(i-j);
                result = result < loc ? loc : result;
            }
        }

        return result;
    }

}
