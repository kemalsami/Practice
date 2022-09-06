import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 */
public class Solution {

    /**
     *
     * Her diagonal sort edilerek tekrardan result array içerisine yerleştirildi
     *
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {

        if(mat.length<2)
            return mat;

        int[][] res = new int[mat.length][mat[0].length];
        int[] list = new int[mat.length];
        for(int i=0; i<mat[0].length; i++){

            int l =  mat[0].length-i < mat.length ? mat[0].length-i : mat.length;

            list = new int[l];
            for(int j=0; j<l; j++){
                list[j] = mat[j][j+i];
            }

            Arrays.sort(list);

            for(int j=0; j<l; j++){
                res[j][i+j] = list[j];
            }

        }


        for(int i=1; i<mat.length; i++){

            int l = mat.length-i < mat[0].length ? mat.length-i : mat[0].length;
            list = new int[l];
            for(int j=0; j<l; j++){
                list[j] = mat[i+j][j];
            }

            Arrays.sort(list);

            for(int j=0; j<l; j++){
                res[i+j][j] = list[j];
            }

        }

        return res;
    }

}
