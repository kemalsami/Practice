public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        int num=0,result;

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        num = -1463847412;
        result = solution.reverse(num);
        System.out.println("RESULT : " + result);

        num = 123;
        result = solution.reverse(num);
        System.out.println("RESULT : " + result);

        num = -123;
        result = solution.reverse(num);
        System.out.println("RESULT : " + result);

        num = 120;
        result = solution.reverse(num);
        System.out.println("RESULT : " + result);

        num = 5;
        result = solution.reverse(num);
        System.out.println("RESULT : " + result);

        num = -5;
        result = solution.reverse(num);
        System.out.println("RESULT : " + result);

        // Expected = 0
        num = 1534236469;
        result = solution.reverse(num);
        System.out.println("RESULT : " + result);

        /*
        System.out.println(Integer.MAX_VALUE);
        int maxVal=(int)Math.pow(2,32);
        System.out.println(maxVal);
         */

    }

}
