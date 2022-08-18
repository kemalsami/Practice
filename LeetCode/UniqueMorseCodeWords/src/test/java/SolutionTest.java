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
        String[] words = {"a"};
        Assert.assertEquals(1,solution.uniqueMorseRepresentations(words));
    }

    @Test
    public void leetCode2(){
        String[] words = {"gin","zen","gig","msg"};
        Assert.assertEquals(2,solution.uniqueMorseRepresentations(words));
    }

}
