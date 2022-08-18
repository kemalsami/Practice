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
        System.out.println("AA");
        int[] nums = {3,2,4};
        int target = 6;
        Assert.assertEquals(1,solution.twoSum(nums, target));
    }


}
