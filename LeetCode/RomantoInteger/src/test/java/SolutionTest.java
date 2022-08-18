import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;
    private String str;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test(timeout = 100)
    public void leetCode1(){
        str = "III";
        Assert.assertEquals(3,solution.romanToInt(str));
    }

    @Test(timeout = 100)
    public void leetCode2(){
        str = "LVIII";
        Assert.assertEquals(58,solution.romanToInt(str));
    }

    @Test(timeout = 100)
    public void leetCode3(){
        str = "MCMXCIV";
        Assert.assertEquals(1994,solution.romanToInt(str));
    }

    @Test(timeout = 100)
    public void singleCharacter(){
        str = "V";
        Assert.assertEquals(5,solution.romanToInt(str));
    }

    @Test(timeout = 100)
    public void duplicateNumbers(){
        str = "XX";
        Assert.assertEquals(20,solution.romanToInt(str));
    }

}
