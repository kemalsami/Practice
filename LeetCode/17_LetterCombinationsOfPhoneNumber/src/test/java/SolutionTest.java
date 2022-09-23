import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setSolution(){
        solution = new Solution();
    }

    @Test
    public void leetcode_1(){
        String digits = "23";
        String[] result = solution.letterCombinations(digits).stream().sorted().toArray(String[]::new);
        String[] expectedResult = {"ad","ae","af","bd","be","bf","cd","ce","cf"};
        Arrays.sort(result);
        Arrays.sort(expectedResult);
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void leetcode_2(){
        String digits = "2";
        String[] result = solution.letterCombinations(digits).stream().sorted().toArray(String[]::new);
        String[] expectedResult = {"a","b","c"};
        Arrays.sort(result);
        Arrays.sort(expectedResult);
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void leetcode_3(){
        String digits = "";
        String[] result = solution.letterCombinations(digits).stream().sorted().toArray(String[]::new);
        String[] expectedResult = {};
        Arrays.sort(result);
        Arrays.sort(expectedResult);
        Assert.assertArrayEquals(expectedResult, result);
    }

}