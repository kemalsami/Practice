import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    public Solution solution;

    @Before
    public void setup(){

        solution = new Solution();
    }


    @Test
    public void leetCode1(){
        Assert.assertTrue(solution.isPowerOfThree(27));
    }

    @Test
    public void leetCode2(){
        Assert.assertFalse(solution.isPowerOfThree(0));
    }

    @Test
    public void leetCode3(){
        Assert.assertTrue(solution.isPowerOfThree(1));
    }

    @Test
    public void leetCode4(){
        Assert.assertTrue(solution.isPowerOfThree(9));
    }
}
