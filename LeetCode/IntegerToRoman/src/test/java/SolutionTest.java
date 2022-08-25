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
        int num=3;
        Assert.assertEquals("III" , solution.intToRoman(num));
    }

    @Test
    public void leetCode2(){
        int num=58;
        Assert.assertEquals("LVIII" , solution.intToRoman(num));
    }

    @Test
    public void leetCode3(){
        int num=1994;
        Assert.assertEquals("MCMXCIV" , solution.intToRoman(num));
    }

}
