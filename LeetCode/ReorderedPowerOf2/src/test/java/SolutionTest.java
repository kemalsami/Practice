import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *  leading digit should not be zero
 */
public class SolutionTest {

    private Solution solution;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void leetcode1(){
        Assert.assertTrue(solution.reorderedPowerOf2(1));
    }

    @Test
    public void leetcode2(){
        Assert.assertFalse(solution.reorderedPowerOf2(10));
    }

    @Test
    public void standartInput1(){
        Assert.assertTrue(solution.reorderedPowerOf2(32));
    }

    @Test
    public void standartInput2(){
        Assert.assertTrue(solution.reorderedPowerOf2(64));
    }

    /**
     * 32
     */
    @Test
    public void powerOfTwoReorderNeed1(){
        Assert.assertTrue(solution.reorderedPowerOf2(23));
    }

    /**
     * 128
     */
    @Test
    public void powerOfTwoReorderNeed2(){
        Assert.assertTrue(solution.reorderedPowerOf2(182));
    }

    /**
     * 1024
     */
    @Test
    public void powerOfTwoReorderNeed3(){
        Assert.assertTrue(solution.reorderedPowerOf2(1240));
    }

    @Test
    public void notPowerOfTwo1(){
        Assert.assertFalse(solution.reorderedPowerOf2(34));
    }

    @Test
    public void notPowerOfTwo2(){
        Assert.assertFalse(solution.reorderedPowerOf2(65));
    }

}
