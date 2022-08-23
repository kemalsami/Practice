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
        String[] strs = {"flower","flow","flight"};
        Assert.assertEquals("fl" , solution.longestCommonPrefix(strs));
    }

    @Test
    public void leetCode2(){
        String[] strs = {"dog","racecar","car"};
        Assert.assertEquals("" , solution.longestCommonPrefix(strs));
    }

    @Test
    public void leetCode3(){
        String[] strs = {"ab", "a"};
        Assert.assertEquals("a" , solution.longestCommonPrefix(strs));
    }

    @Test
    public void leetCode4(){
        String[] strs = {"abab","aba",""};
        Assert.assertEquals("" , solution.longestCommonPrefix(strs));
    }

}
