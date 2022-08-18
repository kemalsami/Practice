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
        Assert.assertEquals(42, solution.myAtoi("42"));
    }

    @Test
    public void leetCode2(){
        Assert.assertEquals(-42, solution.myAtoi("     -42"));
    }

    @Test
    public void leetCode3(){
        Assert.assertEquals(4193, solution.myAtoi("4193 with words"));
    }

    @Test
    public void leetCode4(){
        Assert.assertEquals(-2147483648, solution.myAtoi("-91283472332"));
    }

    @Test
    public void leetCode5(){
        Assert.assertEquals(1, solution.myAtoi("+1"));
    }

    @Test
    public void leetCode6(){
        Assert.assertEquals(0, solution.myAtoi("+-12"));
    }

    @Test
    public void leetCode7(){
        Assert.assertEquals(0, solution.myAtoi("00000-42a1234"));
    }

    @Test
    public void leetCode8(){
        Assert.assertEquals(2147483647, solution.myAtoi("9223372036854775808"));
    }

    @Test
    public void leetCode9(){
        Assert.assertEquals(12345678, solution.myAtoi("  0000000000012345678"));
    }
}
