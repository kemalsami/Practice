import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setSolution(){
        solution = new Solution();
    }

    @Test
    public void leetcode1(){
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] res = {{1,1,1,1},{1,2,2,2},{1,2,3,3}};
        Assert.assertArrayEquals(res,solution.diagonalSort(mat));
    }

    @Test
    public void leetcode2(){
        int[][] mat = {{11,25,66,1,69,7},{23,55,17,45,15,52},{75,31,36,44,58,8},{22,27,33,25,68,4},{84,28,14,11,5,50}};
        int[][] res = {{5,17,4,1,52,7},{11,11,25,45,8,69},{14,23,25,44,58,15},{22,27,31,36,50,66},{84,28,75,33,55,68}};
        Assert.assertArrayEquals(res,solution.diagonalSort(mat));
    }


    @Test
    public void reverseOrder(){
        int[][] mat = {{3,3,1,1},{2,2,2,2},{1,1,1,1}};
        int[][] res = {{1,1,1,1},{1,2,2,2},{1,2,3,3}};
        Assert.assertArrayEquals(res,solution.diagonalSort(mat));
    }

}
