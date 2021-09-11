import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the solve function below.
    static int solve(int[] arr) {

        Stack<Integer> STACK = new Stack<Integer>();
        int groupNum = -1;
        int totalPathCount = 0;
        for(int i=0; i<arr.length; i++){

            groupNum = -1;
            int popCount = 0;
            boolean popStop = false;
            while(!popStop){

                if(STACK.empty()){
                    STACK.push(arr[i]);
                    popStop = true;
                }else {

                    if(STACK.peek()>=arr[i]){
                        popStop = true;
                        STACK.push(arr[i]);
                    }else{

                        int topElement = STACK.pop();
                        if(STACK.size()>0 ){
                            if(topElement==STACK.peek()){
                                groupNum = topElement;
                                popCount++;
                            }else{
                                if(popCount>0){
                                    popCount++;
                                    totalPathCount += ((popCount*(popCount-1))/2);
                                    popCount=0;
                                }
                            }
                        }else{
                            if(popCount>1){
                                if(topElement==groupNum){
                                    popCount++;
                                }
                                totalPathCount += ((popCount*(popCount-1))/2);
                                popCount=0;
                            }
                        }
                    }
                }
            }
        }

        groupNum = -1;
        int popCount=0;
        while(!STACK.isEmpty()){
            int newTop = STACK.pop();

            if(STACK.size()>0){
                if(newTop==STACK.peek()){
                    groupNum = newTop;
                    popCount++;
                }else{

                    if(popCount>0){
                        popCount++;
                        totalPathCount += ((popCount*(popCount-1))/2);
                        popCount=0;
                    }
                }

            }else{
                if(popCount>0){
                    if(newTop==groupNum){
                        popCount++;
                    }
                    totalPathCount += ((popCount*(popCount-1))/2);
                    popCount=0;
                }
            }
        }

        return totalPathCount*2 ;
    }


    static int solveX(int[] arr) {
        boolean invalidPath = false;
        int pathCount= 0;
        for(int i=0; i<arr.length; i++){
            invalidPath = false;
            int c=0;
            ci:
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]>arr[i]){
                    invalidPath = true;
                    break ci;
                }

                if(arr[i]==arr[j] && !invalidPath){
                    pathCount++;
                }
            }
        }

        return pathCount*2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/kemalsamikaraca/Desktop/result.txt"));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        int result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
