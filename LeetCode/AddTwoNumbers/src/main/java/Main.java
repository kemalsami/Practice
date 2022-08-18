/**
 * https://leetcode.com/problems/add-two-numbers/
 */

public class Main {

    public static void main(String[] args){

        Solution solution = new Solution();
        int[] l1 = {2,4,3,7};
        int[] l2 = {5,6,4};

        ListNode list1 = solution.createListNodeFromArray(l1);
        ListNode list2 = solution.createListNodeFromArray(l2);

        ListNode result = solution.addTwoNumbers(list1,list2);
        solution.printListNode(result);

    }

}
