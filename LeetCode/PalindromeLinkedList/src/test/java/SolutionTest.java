import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setuo(){
        solution = new Solution();
    }

    @Test
    public void leetCode1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        Assert.assertTrue(solution.isPalindrome(node1));
    }

}
