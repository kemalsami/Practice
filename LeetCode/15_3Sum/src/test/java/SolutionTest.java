import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setSolution(){
        solution = new Solution();
    }

    @Test
    public void leetcode_1(){
        int[] nums = {-1,0,1,2,-1,-4};
        int[][] expectedResult = {{-1,-1,2},{-1,0,1}};
        List<List<Integer>> functionResult = solution.threeSum(nums);

        int[][] ints = functionResult.stream().map(x -> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

        Assert.assertTrue(Arrays.deepEquals(expectedResult,ints));
    }


    @Test
    public void leetcode_2(){
        int[] nums = {-1,0,1,0};
        List<List<Integer>> result = solution.threeSum(nums);
        Assert.assertTrue(true);
    }

    @Test
    public void leetcode_3(){
        int[] nums = {0,0,0,0};
        List<List<Integer>> result = solution.threeSum(nums);
        Assert.assertTrue(true);
    }

    @Test
    public void leetcode_4(){
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> result = solution.threeSum(nums);
        Assert.assertTrue(true);
    }
}
