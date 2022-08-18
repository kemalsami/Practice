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
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        Assert.assertEquals(2 , solution.minSetSize(arr));
    }

    @Test
    public void leetCode2(){
        int[] arr = {7,7,7,7,7,7};
        Assert.assertEquals(1 , solution.minSetSize(arr));
    }

    @Test
    public void equalsCount(){
        int[] arr = {4,4,4,4,3,3,3,3};
        Assert.assertEquals(1 , solution.minSetSize(arr));
    }

    @Test
    public void distinctNumbers(){
        int[] arr = {1,2,3,4,5,6,7,8};
        Assert.assertEquals(4 , solution.minSetSize(arr));
    }

}
