import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoluitonTest {

    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test(timeout = 20)
    public void leetCode1(){
        int[] nums = {1,2,3,1};
        Assert.assertEquals( 4 , solution.rob(nums));
    }

    @Test(timeout = 20)
    public void leetCode2(){
        int[] nums = {2,7,9,3,1};
        Assert.assertEquals( 12 , solution.rob(nums));
    }

    @Test(timeout = 20)
    public void leetCode3(){
        int[] nums = {2,1,1,2};
        Assert.assertEquals( 4 , solution.rob(nums));
    }

    @Test(timeout = 20)
    public void singleNums(){
        int[] nums = {30};
        Assert.assertEquals( 30 , solution.rob(nums));
    }

    @Test(timeout = 20)
    public void repeatedNumbers(){
        int[] nums = {40,40,40};
        Assert.assertEquals( 80 , solution.rob(nums));
    }

}
