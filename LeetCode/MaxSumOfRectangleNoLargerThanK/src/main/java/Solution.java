import java.util.TreeSet;

/**
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 *
 *
 * Kadane's Algorithm
 *      https://www.youtube.com/watch?v=yCQN096CwWM (*****)
 *
 *      https://www.interviewbit.com/blog/maximum-subarray-sum/ (***)
 *
 */
public class Solution {

    private static int maxValueLessThanK = Integer.MIN_VALUE;
    private static int[][][][] area;

    /**
     *
     * TODO: Soru analizi
     *
     * Soru shortest path problemi gibi düşünebilir. Çünkü "k" değerine ulaşıldığı anda çözüm dönülmelidir
     *
     * Soru ile alakalı bir diğer durum ise alanların tekrar tekrar hesaplanması durumudur. Bunun çözümü için
     * dinamik programlamadan yararlanmalıdır. Bir alan hesaplanırken içindeki diğer alanlar hesaplanmışsa tekrar
     * hesaplanmadan kullanılmalıdır.
     *
     * Dinamik programlamaya ek olarak divide & conquer ile bir alan küçük alanlara recursive şekilde parçalanıp
     * hesaplanabilir. Tabi küçük alanlardan büyük alanlar hesaplanırken küçük alanların daha önceki hesaplamaları
     * tekrar yapılmamalıdır.
     *
     * Sonuç olarak brute force yaklaşımıyla tüm alanların hesaplanması üzerinde durulmamalıdır.
     *
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {

        String solution = "kadane";
        switch (solution){
            case "divideAndConquer_1":
                area = new int[matrix.length][matrix[0].length][matrix.length][matrix[0].length];
                maxValueLessThanK = Integer.MIN_VALUE;
                divideAndConquer_version_1(matrix , k , 0,0,matrix.length-1, matrix[0].length-1);
                return maxValueLessThanK;
            case "divideAndConquer_2":
                int rowLength = matrix.length;
                int columnLength = matrix[0].length;
                maxValueLessThanK = Integer.MIN_VALUE;
                area = new int[rowLength][columnLength][rowLength][columnLength];
                divideAndConquer(matrix , k , 0,0,matrix.length-1, matrix[0].length-1);
                return maxValueLessThanK;

            default:
                break;

        }

        return kadaneAlgorithmSolution(matrix, k);
    }


    public int kadaneAlgorithmSolution(int[][] matrix, int k){

        int maxSum = Integer.MIN_VALUE;
        for(int left=0; left<matrix.length; left++){
            int[] temp = new int[matrix[left].length];
            for(int right=left; right<matrix.length; right++){

                for(int i=0; i< temp.length ; i++){
                    temp[i] += matrix[right][i];
                }

                TreeSet<Integer> tree = new TreeSet<>();
                tree.add(0);

                // kadane's approach for 1D array
                int currentSum = 0;
                for(int i=0; i<temp.length; i++){
                    currentSum += temp[i];

                    Integer num = tree.ceiling(currentSum - k);
                    if(num != null)
                        maxSum = Math.max( maxSum, currentSum - num );

                    if(maxSum==k)
                        return maxSum;

                    tree.add(currentSum);
                }

            }
        }
        return maxSum;

    }



    /**
     *
     *
     *
     * @param matrix
     * @param k
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public int divideAndConquer(int[][] matrix, int k, int a, int b, int c, int d){

        //System.out.printf("\n(%d , %d) - (%d , %d)" , a,b,c,d);
        if(k==maxValueLessThanK)
            return 0;

        if(area[a][b][c][d]!=0){
            return area[a][b][c][d];
        }

        if(a==c && b==d){
            area[a][b][c][d] = matrix[a][b];
            //maxValueLessThanK = matrix[a][b]<=k && matrix[a][b]>maxValueLessThanK ? matrix[a][b] : maxValueLessThanK;;
            //return matrix[a][b];
        }

        if(a<c){
            area[a][b][c][d] = divideAndConquer(matrix,k,a+1,b,c,d) + divideAndConquer(matrix, k, a, b, a, d);
            area[a][b][c][d] = divideAndConquer(matrix,k,a,b,c-1,d) + divideAndConquer(matrix, k, c, b, c, d);
        }

        if(b<d){
            area[a][b][c][d] = divideAndConquer(matrix,k,a,b+1,c,d) + divideAndConquer(matrix, k, a, b, c, b);
            area[a][b][c][d] = divideAndConquer(matrix,k,a,b,c,d-1) + divideAndConquer(matrix, k, a, d, c, d);
        }

        //System.out.printf("\n(%d , %d) - (%d , %d) -> %d" , a,b,c,d, area[a][b][c][d]);
        maxValueLessThanK = area[a][b][c][d]<=k && area[a][b][c][d]>maxValueLessThanK ? area[a][b][c][d] : maxValueLessThanK;

        return area[a][b][c][d];
    }


    /**
     *
     * @param area
     */
    private static void printArea(int area[][][][]){
        for(int a=0; a<area.length; a++){
            for(int b=0; b<area[a].length; b++){

                for(int c=0; c<area[a][b].length; c++){
                    for(int d=0; d<area[a][b][c].length; d++){

                        System.out.printf("\n (%d %d) - (%d %d) -> %d", a , b ,c , d , area[a][b][c][d]);
                    }
                }

            }
        }
    }


    /**
     *
     * @param matrix
     * @param k
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public int divideAndConquer_version_1(int[][] matrix, int k, int a, int b, int c, int d){

        if(a>c || b>d)
            return 0;

        if(a==c && b==d){
            area[a][b][c][d] = matrix[a][b];
            return matrix[a][b];
        }

        int s,x,y,z,t,w;
        if(c-a == d-b){
            //x = a(matrix , k, a+1, b, c, d);
            if(area[a+1][b][c][d]==0){
                x = divideAndConquer_version_1(matrix, k, a+1, b, c,d) ;
            }else {
                x = area[a+1][b][c][d];
            }
            maxValueLessThanK = x<=k && x>maxValueLessThanK ? x : maxValueLessThanK;;

            //y = a(matrix , k, a, b+1, c, d);
            if(area[a][b+1][c][d]==0){
                y = divideAndConquer_version_1(matrix, k, a, b+1, c,d) ;
            }else {
                y = area[a][b+1][c][d];
            }
            maxValueLessThanK = y<=k && y>maxValueLessThanK ? y : maxValueLessThanK;;

            //z = a(matrix , k, a, b, c-1, d);
            if(area[a][b][c-1][d]==0){
                z = divideAndConquer_version_1(matrix, k, a, b, c-1,d);
            }else{
                z = area[a][b][c-1][d];
            }
            maxValueLessThanK = z<=k && z>maxValueLessThanK ? z : maxValueLessThanK;;

            //t = a(matrix , k, a, b, c, d-1);
            if(area[a][b][c][d-1]==0){
                t = divideAndConquer_version_1(matrix, k, a, b, c,d-1);
            }else{
                t = area[a][b][c][d-1];
            }
            maxValueLessThanK = t<=k && t>maxValueLessThanK ? t : maxValueLessThanK;;

            //w = a(matrix , k, a+1, b, c-1, d);
            if(area[a+1][b][c-1][d]==0){
                w = divideAndConquer_version_1(matrix, k, a+1, b, c-1,d);
            }else {
                w = area[a+1][b][c-1][d];
            }

            s = (x+z-w);
            maxValueLessThanK = s<=k && s>maxValueLessThanK ? s : maxValueLessThanK;
            area[a][b][c][d] = s;
            return s;

        }else if(c-a > d-b){
            //x = a(matrix, k, a+1, b, c,d);
            if(area[a+1][b][c][d]==0){
                x = divideAndConquer_version_1(matrix, k, a+1, b, c,d) ;
            }else {
                x = area[a+1][b][c][d];
            }
            maxValueLessThanK = x<=k && x>maxValueLessThanK ? x : maxValueLessThanK;;

            //y = a(matrix, k, a, b, c-1,d);
            if(area[a][b][c-1][d]==0){
                y = divideAndConquer_version_1(matrix, k, a, b, c-1,d);
            }else{
                y = area[a][b][c-1][d];
            }
            maxValueLessThanK = y<=k && y>maxValueLessThanK ? y : maxValueLessThanK;

            //z = a(matrix, k, a+1, b, c-1,d);
            if(area[a+1][b][c-1][d]==0){
                z = divideAndConquer_version_1(matrix, k, a+1, b, c-1,d);
            }else {
                z = area[a+1][b][c-1][d];
            }

            s = x+y-z;
            maxValueLessThanK = s<=k && s>maxValueLessThanK ? s : maxValueLessThanK;
            area[a][b][c][d] = s;
            return s;


        }else if(c-a < d-b){

            if(area[a][b+1][c][d]==0){
                x = divideAndConquer_version_1(matrix, k, a, b+1, c,d) ;
            }else {
                x = area[a][b+1][c][d];
            }
            maxValueLessThanK = x<=k && x>maxValueLessThanK ? x : maxValueLessThanK;

            if(area[a][b][c][d-1]==0){
                y = divideAndConquer_version_1(matrix, k, a, b, c,d-1);
            }else{
                y = area[a][b][c][d-1];
            }
            maxValueLessThanK = y<=k && y>maxValueLessThanK ? y : maxValueLessThanK;

            if(area[a][b+1][c][d-1]==0){
                z = divideAndConquer_version_1(matrix, k, a, b+1, c,d-1);
            }else {
                z = area[a][b+1][c][d-1];
            }

            s = x+y-z;
            maxValueLessThanK = s<=k && s>maxValueLessThanK ? s : maxValueLessThanK;
            area[a][b][c][d] = s;
            return s;
        }

        return maxValueLessThanK;
    }

}
