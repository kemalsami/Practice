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
        String ransomNote = "a";
        String magazine = "b";
        Assert.assertFalse(solution.canConstruct(ransomNote,magazine));
    }

    @Test
    public void leetCode2(){
        String ransomNote = "aa";
        String magazine = "ab";
        Assert.assertFalse(solution.canConstruct(ransomNote,magazine));
    }

    @Test
    public void leetCode3(){
        String ransomNote = "aa";
        String magazine = "aab";
        Assert.assertTrue(solution.canConstruct(ransomNote,magazine));
    }

    @Test
    public void leetCode4(){
        String ransomNote = "aab";
        String magazine = "baa";
        Assert.assertTrue(solution.canConstruct(ransomNote,magazine));
    }

}
