import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;
    private TreeNode root;

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void oneNodeTest(){
        root = new TreeNode(2 , new TreeNode(1) , new TreeNode(3));
        Assert.assertTrue(solution.isValidBST(root));
    }

    @Test
    public void childNodeContainerInvalid(){
        root = new TreeNode(40 , new TreeNode(10) , new TreeNode(100));
        TreeNode node = new TreeNode(20);
        root.right.left = node;
        Assert.assertFalse(solution.isValidBST(root));
    }

    @Test
    public void childNodeContainerValid(){
        root = new TreeNode(40 , new TreeNode(10) , new TreeNode(100));
        TreeNode node = new TreeNode(50);
        root.right.left = node;
        Assert.assertTrue(solution.isValidBST(root));
    }

    @Test
    public void allValuesAreSame(){
        root = new TreeNode(20 , new TreeNode(20) , new TreeNode(20));
        TreeNode node = new TreeNode(20);
        root.right.left = node;
        Assert.assertFalse(solution.isValidBST(root));
    }

    @Test
    public void singleNodeWithMaxInteger(){
        root = new TreeNode(Integer.MAX_VALUE);
        Assert.assertTrue(solution.isValidBST(root));
    }

    @Test
    public void treeWithMaxAndMınIntegers(){
        root = new TreeNode(20 , new TreeNode(Integer.MIN_VALUE) , new TreeNode(Integer.MAX_VALUE));
        Assert.assertTrue(solution.isValidBST(root));
    }

    @Test
    public void treeWithMultiMaxAndMınIntegers(){
        root = new TreeNode(20 , new TreeNode(Integer.MIN_VALUE) , new TreeNode(Integer.MAX_VALUE));
        TreeNode node = new TreeNode(Integer.MAX_VALUE);
        root.right.left = node;
        Assert.assertFalse(solution.isValidBST(root));
    }

    @Test
    public void treeWithMultiMaxIntegers(){
        root = new TreeNode(Integer.MAX_VALUE , new TreeNode(Integer.MAX_VALUE) , new TreeNode(Integer.MAX_VALUE));
        Assert.assertFalse(solution.isValidBST(root));
    }

}
