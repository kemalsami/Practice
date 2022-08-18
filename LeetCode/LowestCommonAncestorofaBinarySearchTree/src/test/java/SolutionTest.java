import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private TreeNode root;
    private Solution solution;

    @Before
    public void setup(){
        root = new TreeNode(6);
        solution = new Solution();
    }

    @Test
    public void initialTest(){
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(8);
        root.left = rootLeft;
        root.right = rootRight;
        Assert.assertEquals(6, solution.lowestCommonAncestor(root, rootLeft,rootRight).val);
    }

    @Test
    public void moreComplexTree(){
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(8);
        TreeNode l1 = new TreeNode(0);
        TreeNode l2 = new TreeNode(4);
        TreeNode r1 = new TreeNode(7);
        TreeNode r2 = new TreeNode(9);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(5);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = l1;
        rootLeft.right = l2;
        l2.left = l21;
        l2.right = l22;
        rootRight.left = r1;
        rootRight.right = r2;

        Assert.assertEquals(6, solution.lowestCommonAncestor(root, l2,r1).val);
    }

    @Test
    public void moreComplexTree1(){
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(8);
        TreeNode l1 = new TreeNode(0);
        TreeNode l2 = new TreeNode(4);
        TreeNode r1 = new TreeNode(7);
        TreeNode r2 = new TreeNode(9);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(5);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = l1;
        rootLeft.right = l2;
        l2.left = l21;
        l2.right = l22;
        rootRight.left = r1;
        rootRight.right = r2;

        Assert.assertEquals(4, solution.lowestCommonAncestor(root, l21,l22).val);
    }

    @Test
    public void moreComplexTree2(){
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(8);
        TreeNode l1 = new TreeNode(0);
        TreeNode l2 = new TreeNode(4);
        TreeNode r1 = new TreeNode(7);
        TreeNode r2 = new TreeNode(9);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(5);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = l1;
        rootLeft.right = l2;
        l2.left = l21;
        l2.right = l22;
        rootRight.left = r1;
        rootRight.right = r2;

        Assert.assertEquals(2, solution.lowestCommonAncestor(root, rootLeft,l2).val);
    }

}
