import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    public Solution solution;

    @Before
    public void setSolution(){
        solution = new Solution();
    }

    @Test
    public void leetcode_1(){
        int  properties [][]= {{5,5},{6,3},{3,6}};
        Assert.assertEquals( 0,solution.numberOfWeakCharacters(properties));
    }

    @Test
    public void leetcode_2(){
        int  properties [][]= {{2,2},{3,3}};
        Assert.assertEquals( 1,solution.numberOfWeakCharacters(properties));
    }

    @Test
    public void leetcode_3(){
        int  properties [][]= {{1,5},{10,4},{4,3}};
        Assert.assertEquals( 1,solution.numberOfWeakCharacters(properties));
    }

    @Test
    public void leetcode_4(){
        int  properties [][]= {{1,5},{10,4},{4,3},{2,6}};
        Assert.assertEquals( 2,solution.numberOfWeakCharacters(properties));
    }

    @Test
    public void leetcode_5(){
        int  properties [][]= {{7,9},{10,7},{6,9},{10,4},{7,5},{7,10}};
        Assert.assertEquals( 2,solution.numberOfWeakCharacters(properties));
    }

    @Test
    public void weakRepetition(){
        /**
         * 4,3 karakteri 10,4 ve 12,4 karakterlerinden zayıftır ancak zayıf karakter olarak tek bir tane olmalıdır
         */
        int  properties [][]= {{1,5},{10,4},{4,3},{12,4}};
        Assert.assertEquals( 1,solution.numberOfWeakCharacters(properties));
    }

    @Test
    public void sameAttackDifferentDefense(){
        int  properties [][]= {{1,6},{1,7},{1,8},{4,4},{2,8}};
        Assert.assertEquals( 2,solution.numberOfWeakCharacters(properties));
    }

    @Test
    public void singleStrong(){
        int  properties [][]= {{1,1},{2,2},{3,3},{4,4},{5,5}};
        Assert.assertEquals( 4,solution.numberOfWeakCharacters(properties));
    }

}
