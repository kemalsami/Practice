import java.util.Scanner;

public class Solution {

    public static Node createBST(){
        Node root = new Node(1);
        Node _1 = new Node(1);
        Node _2 = new Node(2);
        Node _2_2 = new Node(2);
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        Node _7 = new Node(7);
        root.left = _2;
        root.right = _2_2;
        _2.left = _4;
        _2.right = _5;
        _2_2.left = _6;
        _2_2.right = _7;

        return root;
    }

    /**
     *
     * TEST CASES
     *
     * YES
     * 2
     * 1 2 3 4 5 6 7
     *
     * NO -
     * 2
     * 1 2 2 4 5 6 7
     *
     * NO -
     * 4
     * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 16 18 19 20 21 22 23 24 25 26 27 28 29 30 31
     *
     * NO
     * 2
     * 1 2 3 5 4 6 7
     *
     * YES
     * 4
     * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
     *
     * @param args
     */
    public static void main(String[] args){

        /*
        Scanner scan = new Scanner(System.in);
        scan.next();
        scan.next();
         */

        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        Node root = createBST();
        boolean result = checkBST(root);
        System.out.println("RESULT :" + result);
    }

    /**
     *
     * @param root
     * @return
     */

    public static boolean checkBST(Node root) {
        return checkRootData(root, null,null);
    }

    public static boolean checkRootData(Node node, Node nodeMin, Node nodeMax){

        if(node==null)
            return true;

        //System.out.println("NODE data : " + node.data);

        // initial search
        if(nodeMin==null && nodeMax==null){
            return checkRootData(node.left , null , node) &&
                    checkRootData(node.right , node , null);

        } else if(nodeMin==null){
            if(node.data < nodeMax.data){
                return checkRootData(node.left , null , node) &&
                        checkRootData(node.right , node , nodeMax);
            }
        } else if(nodeMax==null){
            if(nodeMin.data < node.data){
                return checkRootData(node.right , node , null) &&
                        checkRootData(node.left , nodeMin  , node);
            }
        } else {
            if(nodeMin.data < node.data && node.data < nodeMax.data) {
                return checkRootData(node.left , nodeMin , node) &&
                        checkRootData(node.right , node , nodeMax);
            }
        }

        return false;
    }

}

class Node {

    public Node(int data){
        this.data = data;
    }
    int data;
    Node left;
    Node right;
}
