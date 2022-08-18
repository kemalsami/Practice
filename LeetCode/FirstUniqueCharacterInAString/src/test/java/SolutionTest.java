import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;
    private String s;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test(timeout = 50)
    public void leetCode1(){
        s = "leetcode";
        Assert.assertEquals(0 , solution.firstUniqChar(s));
    }

    @Test(timeout = 50)
    public void leetCode2(){
        s = "loveleetcode";
        Assert.assertEquals(2 , solution.firstUniqChar(s));
    }

    @Test(timeout = 50)
    public void leetCode3(){
        s = "aabb";
        Assert.assertEquals(-1 , solution.firstUniqChar(s));
    }

    @Test(timeout = 50)
    public void leetCode4(){
        s = "aabbzcc";
        Assert.assertEquals(4 , solution.firstUniqChar(s));
    }

}
