/**
 * https://leetcode.com/problems/power-of-three/
 */
public class Solution {

    /**
     *
     * n%2 kontrolü ile işlem hızlanmıştır
     * 
     * 19 ms, faster than 80.11% of Java online submissions for Power of Three.
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {

        if(n<1)
            return false;

        if(n%2==0)
            return false;

        while(n%3==0){
            n/=3;
        }

        if(n==1)
            return true;

        return false;

    }

}
