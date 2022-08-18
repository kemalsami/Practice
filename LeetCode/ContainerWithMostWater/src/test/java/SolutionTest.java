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
        int[] height = {1,8,6,2,5,4,8,3,7};
        Assert.assertEquals(49, solution.maxArea(height));
    }

    @Test
    public void leetCode2(){
        int[] height = {1,1};
        Assert.assertEquals(1, solution.maxArea(height));
    }

    @Test
    public void leetCode3(){
        int[] height = {1,6,5,1,1,1,1};
        Assert.assertEquals(6, solution.maxArea(height));
    }

    @Test
    public void leetCode4(){
        int[] height = {8,6,24,25};
        Assert.assertEquals(24, solution.maxArea(height));
    }

    @Test
    public void leetCode5(){
        int[] height = {2,5,3,2,1};
        Assert.assertEquals(6, solution.maxArea(height));
    }

    @Test
    public void widthHeightChange(){
        int[] height = {6,1,2,1,3,7,50,52,5};
        Assert.assertEquals(50, solution.maxArea(height));
    }

    @Test
    public void widthHeightChange2(){
        int[] height = {6,1,2,1,3,7,20,22,5};
        Assert.assertEquals(42, solution.maxArea(height));
    }


    @Test
    public void widthHeightChange3(){
        int[] height = {6,6};
        Assert.assertEquals(6, solution.maxArea(height));
    }


    @Test
    public void decrease(){
        int[] height = {4,1,1,1,4,1,3,1,2};
        Assert.assertEquals(18, solution.maxArea(height));
    }


}
