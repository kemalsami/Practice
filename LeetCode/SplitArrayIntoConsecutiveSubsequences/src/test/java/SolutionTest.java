import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void leetCode1(){
        int[] nums = {1,2,3,3,4,5};
        Assert.assertTrue(solution.isPossible(nums));
    }

    @Test
    public void leetCode2(){
        int[] nums = {1,2,3,3,4,4,5,5};
        Assert.assertTrue(solution.isPossible(nums));
    }

    @Test
    public void leetCode3(){
        int[] nums = {1,2,3,4,4,5};
        Assert.assertFalse(solution.isPossible(nums));
    }


    /**
     * 1,2,3,4,5
     *         5,6,7
     *
     *
     *  p1  p2    p3     p1
     *  i, i+1,   i+2,   i+3
     *  n, n+m,  n+m+k   m+k
     *                    p3-p1
     *
     *  1   3      3      2
     *
     *  1,2,3
     *    2,3
     *    2,3
     *
     */
    @Test
    public void leetCode4(){
        int[] nums = {1,2,3,4,5,5,6,7};
        Assert.assertTrue(solution.isPossible(nums));
    }

    /**
     * 1,2,3,4,5,6
     *         5,6,7
     */
    @Test
    public void leetCode6(){
        int[] nums = {1,2,3,4,5,5,6,6,7};
        Assert.assertTrue(solution.isPossible(nums));
    }

    /**
     * 1,2,3
     *   2,3,4
     *     3,4,5
     */
    @Test
    public void consecutiveSequences(){
        int[] nums = {1,2,2,3,3,3,4,4,5};
        Assert.assertTrue(solution.isPossible(nums));
    }

    /**
     * 1,2,3
     *     3,4,5
     *     3,4,5
     *     3,4,5,6
     */
    @Test
    public void consecutiveSequences2(){
        int[] nums = {1,2,3,3,3,3,4,4,4,5,5,5,6};
        Assert.assertTrue(solution.isPossible(nums));
    }

    /**
     * 1,2,3,4
     *     3,4,5
     *     3,4,5
     *     3,4,5,6
     */
    @Test
    public void consecutiveSequences3(){
        int[] nums = {1,2,3,3,3,3,4,4,4,4,5,5,5,6};
        Assert.assertTrue(solution.isPossible(nums));
    }


    /**
     * 1,2,3
     * 1,2,3,4
     * 1,2,3,4
     *   2,3,4
     *   2,3,4,5
     */
    @Test
    public void consecutiveSequences4(){
        int[] nums = {1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,5};
        Assert.assertTrue(solution.isPossible(nums));
    }

    /**
     * 1,2,3
     *       4,5,6
     *             7,8,9
     */
    @Test
    public void defaultTest(){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        Assert.assertTrue(solution.isPossible(nums));
    }

    @Test
    public void arraySizeLessThenThree(){
        int[] nums = {1};
        Assert.assertFalse(solution.isPossible(nums));
    }

}
