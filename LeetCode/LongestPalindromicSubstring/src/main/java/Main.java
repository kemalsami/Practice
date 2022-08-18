public class Main {

    /**
     * Not: Zamanında etkili şekilde çözülemedi (30dk içinde)
     *
     * @param args
     */
    public static void main(String[] args){

        Solution solution = new Solution();
        String result, str;

        str = "x";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);

        str = "yy";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);

        str = "zzz";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);

        str = "ccd";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);

        str = "babad";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);

        str = "cbbd";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);

        str = "accccbde";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);

        str = "abcddeeddfr";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);

        str = "xybbabbzt";
        result = solution.longestPalindrome(str);
        System.out.println("RESULT : " + result);
    }

}
