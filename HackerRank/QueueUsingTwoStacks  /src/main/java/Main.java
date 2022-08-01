import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args){
        solution2();
    }



    public static void solution2(){

        Scanner scan = new Scanner(System.in);
        int query = scan.nextInt();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        for(int i=0; i<query; i++){

            int operation = scan.nextInt();
            switch (operation){

                // 1 x: Enqueue element into the end of the queue.
                case 1:
                    stack1.push(scan.nextInt());
                    break;

                // 2: Dequeue the element at the front of the queue.
                case 2:

                    if(stack2.isEmpty()){
                        while(!stack1.empty()){
                            stack2.push(stack1.pop());
                        }

                    }

                    if(!stack2.empty()){
                        stack2.pop();
                    }

                    //System.out.println("Delete element from Stack ");
                    break;

                // 3: Print the element at the front of the queue.
                case 3:
                    if(stack2.isEmpty()){
                        while(!stack1.empty()){
                            stack2.push(stack1.pop());
                        }
                    }
                    if(!stack2.empty()){
                        System.out.println(stack2.peek());
                    }

                    break;

                default:
                    break;
            }
        }
    }


    /**
     *  Time limit exceeded
     *
     *  Your code did not execute within the time limits. Please optimize your code.
     *  For more information on execution time limits, refer to the environment page
     */
    public static void solution1(){

        Scanner scan = new Scanner(System.in);
        int query = scan.nextInt();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        for(int i=0; i<query; i++){

            int operation = scan.nextInt();
            switch (operation){

                // 1 x: Enqueue element into the end of the queue.
                case 1:

                    while(!stack2.empty()){
                        stack1.push(stack2.pop());
                    }
                    stack1.push(scan.nextInt());

                    //System.out.println("Insert element to Stack ");
                    break;

                // 2: Dequeue the element at the front of the queue.
                case 2:
                    while(!stack1.empty()){
                        stack2.push(stack1.pop());
                    }
                    if(!stack2.empty())
                        stack2.pop();

                    //System.out.println("Delete element from Stack ");
                    break;

                // 3: Print the element at the front of the queue.
                case 3:
                    while(!stack1.empty()){
                        stack2.push(stack1.pop());
                    }
                    if(!stack2.empty()){
                        System.out.println(stack2.peek());
                    }

                    break;

                default:
                    break;
            }
        }
    }

}
