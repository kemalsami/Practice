
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    /**
     *
     * @param arr
     * @return
     */
    public ListNode createListNodeFromArray(int[] arr){
        ListNode rootNode=null;
        ListNode tail=null;
        for(int i=0; i<arr.length; i++){
            ListNode newNode = new ListNode(arr[i]);
            if(rootNode==null){
                rootNode = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return rootNode;
    }


    /**
     *
     * @param listNode
     */
    public void printListNode(ListNode listNode){
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }


    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean cont=true;
        ListNode result = null ;
        ListNode prev = null;
        int p=0;
        do{

            if(l1==null && l2==null){
                if(p>0){
                    ListNode newNode = new ListNode();
                    newNode.val = p;
                    prev.next = newNode;
                }
                break;
            }


            int x = l1!=null ? l1.val : 0;
            int y = l2!=null ? l2.val : 0;


            ListNode newNode = new ListNode();
            newNode.val = (x + y + p)%10;
            p = (x + y + p)/10;

            if(result == null){
                result = newNode;
                prev = result;
            }else{
                prev.next = newNode;
                prev = prev.next;
            }

            l1=l1!=null ? l1.next : null;
            l2=l2!=null ? l2.next : null;
        }while(true);

        return result;
    }

}
