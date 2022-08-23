import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Solution {


    /**
     *
     * Palindrome integer olabilmesi için gelen değerleri birini başına diğerini sonuna koyarız
     *
     * Eğer listenin sonuna geldiğimizde bu sayılar eşitse palindrome diyebiliriz
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        int a=-1;
        int b=-1;
        int power=10;
        if(head!=null){
            a = head.val;
            b = head.val;
            head = head.next;
        }


        while(head != null){
            a = a*10+head.val;
            b = head.val*power+b;
            power *= 10;
            head = head.next;
        }

        return a==b;
    }


    /**
     *
     * 44 ms, faster than 9.97% of Java online submissions for Palindrome Linked List.
     *
     * @param head
     * @return
     */
    public boolean isPalindrome_accepted_v1(ListNode head) {

        Stack<Integer> stack = new Stack<Integer>();
        ListNode tail = head;
        while(tail != null){
            stack.push(tail.val);
            tail = tail.next;
        }


        while (head.next!=null){
            if(head.val!=stack.pop())
                return false;

            head=head.next;
        }

        return true;
    }

}
