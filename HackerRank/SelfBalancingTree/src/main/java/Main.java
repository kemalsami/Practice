
public class Main {

    public static void main(String[] args){
        System.out.println("Self Balancing Tree");

        // Create Self Balancing Tree
        Node root = insert(null , 3);
        root = insert(root , 2);
        root = insert(root , 4);
        root = insert(root , 5);

        //calculateHeight(root);
        //printTree(root);

        System.out.println("----- PRINT TREE ----- ");
        printTree(root);

        root = insert(root , 6);
        System.out.println("----- PRINT TREE ----- ");
        printTree(root);
    }

    public static void printTree(Node root){

        if(root.left!=null)
            printTree(root.left);

        // In Order
        // System.out.println(root.val + " - " + root.ht);

        if(root.right!=null)
            printTree(root.right);

        // print
        System.out.println(root.val + " - " + root.ht + " - " + getBalanceFactor(root) );
    }

    public static void setNodeHeight(Node node){
        if(node.right==null && node.left==null){
            node.ht=0;
        }else if(node.right!=null && node.left==null){
            node.ht = node.right.ht+1;
        }else if(node.left!=null && node.right==null){
            node.ht = node.left.ht+1;
        }else {
            node.ht = node.left.ht > node.right.ht ? node.left.ht + 1 : node.right.ht + 1;
        }
    }

    public static int getBalanceFactor(Node node){
        int balanceFactor = 0;
        if(node.left==null && node.right!=null){
            balanceFactor =  0 - (node.right.ht+1);
        }else if(node.right==null && node.left!=null){
            balanceFactor =  (node.left.ht+1)- 0;
        }else if(node.left!=null && node.right!=null){
            balanceFactor = node.left.ht - node.right.ht;
        }
        return balanceFactor;
    }

    /**
     *
     * BST üzerinde yeni gelen değerin yerleştirilmesi için recursive olarak tree üzerinde ilerlenir
     *
     * Yeni node oluşturulduktan sonra recursive olarak root'a dönerken height ve balanceFactor değerler hesaplanır
     *
     * Eğer tree'de rotate etme işlemi gerekliyse rotate edilir
     *
     * @param root
     * @param val
     * @return
     */
    public static Node insert(Node root, int val){

        // Default case
        if(root==null){
            root = new Node();
            root.val = val;
            root.ht = 0;
        //
        }else{
            if(root.val < val){
                if(root.right != null){
                    root.right = insert(root.right , val);
                }else {
                    Node node = new Node();
                    node.val = val;
                    node.ht = 0;
                    root.right = node;
                }
            }else {
                if(root.left != null){
                    root.left = insert(root.left , val);
                }else {
                    Node node = new Node();
                    node.val = val;
                    node.ht = 0;
                    root.left = node;
                }
            }
        }

        // Calculate Node Height
        setNodeHeight(root);

        int balanceFactor = getBalanceFactor(root);
        if(balanceFactor==2){
            int leftChildBalanceFactor = getBalanceFactor(root.left);
            if(leftChildBalanceFactor==1){
                // rotate right
                root = rotateRight(root);

            }else if(leftChildBalanceFactor==-1){
                // rotate left-right
                root = rotateLeftRight(root);
            }
        }else if(balanceFactor==-2){
            int rightChildBalanceFactor = getBalanceFactor(root.right);
            if(rightChildBalanceFactor==-1){
                // rotate left
                root = rotateLeft(root);
            }else if(rightChildBalanceFactor==1){
                // rotate right-left
                root = rotateRightLeft(root);
            }
        }

        return root;
    }


    /**
     *       A               A                       C
     *         \               \                   /   \
     *          B      -->      C        -->     B      A
     *         /                  \
     *        C                     B
     */
    public static Node rotateRightLeft(Node A){
        Node B = A.right;
        Node C = B.left;

        A.left = A.left;
        A.right = C.left;

        B.right = B.right;
        B.left = C.right;

        C.right = B;
        C.left = A;

        setNodeHeight(A);
        setNodeHeight(B);
        setNodeHeight(C);
        return C;
    }

    /**
     *            A              A                  C
     *          /               /                 /   \
     *        B        -->     C        -->     B      A
     *         \             /
     *          C           B
     */
    public static Node rotateLeftRight(Node A){
        Node B = A.left;
        Node C = B.right;

        A.right = A.right;
        A.left = C.right;

        B.left = B.left;
        B.right = C.left;

        C.right = A;
        C.left = B;

        setNodeHeight(A);
        setNodeHeight(B);
        setNodeHeight(C);
        return C;
    }


    /**
     *          A               B
     *         /               / \
     *        B      -->      C   A
     *       /
     *      C
     */
    public static Node rotateRight(Node A){
        Node B = A.left;
        Node C = B.left;

        A.left = B.right;
        B.right = A;

        setNodeHeight(A);
        setNodeHeight(C);
        setNodeHeight(B);
        return B;
    }

    /**
     *       A                      B
     *        \                    / \
     *         B        -->      A     C
     *          \
     *            C
     */
    public static Node rotateLeft(Node A){
        Node B = A.right;
        Node C = B.right;

        A.right = B.left;
        B.left = A;

        setNodeHeight(A);
        setNodeHeight(C);
        setNodeHeight(B);
        return B;
    }


    public static void calculateHeightOfAllNodes(Node node){
        if(node.left!=null)
            calculateHeightOfAllNodes(node.left);

        if(node.right!=null)
            calculateHeightOfAllNodes(node.right);

        setNodeHeight(node);
    }

}

class Node {
    int val;	//Value
    int ht;		//Height
    Node left;	//Left child
    Node right;	//Right child
}
