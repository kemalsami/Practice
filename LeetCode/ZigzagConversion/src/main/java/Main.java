public class Main {

    /**
     * https://leetcode.com/problems/zigzag-conversion/
     */
    public static void main(String[] args){
        Solution solution = new Solution();
        String str,result;
        int numRows;


        str = "PAYPALISHIRING";
        numRows = 3;
        result = solution.convert(str,numRows);
        System.out.println("RESULT : " + result);


        str = "ABCDE";
        numRows = 4;
        result = solution.convert(str,numRows);
        System.out.println("RESULT : " + result);


        str = "PAYPALISHIRING";
        numRows = 4;
        result = solution.convert(str,numRows);
        System.out.println("RESULT : " + result);

        str = "A";
        numRows = 1;
        result = solution.convert(str,numRows);
        System.out.println("RESULT : " + result);


        str = "ABCD";
        numRows = 2;
        result = solution.convert(str,numRows);
        System.out.println("RESULT : " + result);

        str = "ABCDE";
        numRows = 2;
        result = solution.convert(str,numRows);
        System.out.println("RESULT : " + result);

    }

}
