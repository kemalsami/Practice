package tr.com.seruvent;

public class Main {

    public static void main(String[] args){

        // Create Huffman Tree for test cases
        Node b = new Node(1);
        b.data = 'B';
        Node c = new Node(1);
        c.data = 'C';
        Node bc = new Node(2);
        bc.right = c;
        bc.left = b;

        Node a = new Node(3);
        a.data = 'A';

        Node abc = new Node(5);
        abc.right = a;
        abc.left = bc;

        // call function
        decode("1001011" , abc);

    }

    public static void decode(String s, Node root) {

        String decodeResult = "";
        Node temp = root;
        for (int i=0; i<s.length(); i++) {

            // if it's leaf node then get data and return to root node
            if (temp.data!=0){
                decodeResult += temp.data;
                temp = root;
            }


            if(s.charAt(i)=='1'){
                temp = temp.right;
            }else{
                temp = temp.left;
            }

        }

        // Last node have to data so it should be added to decoded string
        decodeResult += temp.data;

        System.out.println(decodeResult);
    }

}

class Node{
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right;
    Node(int frequency){
        this.frequency = frequency;
    }
}
