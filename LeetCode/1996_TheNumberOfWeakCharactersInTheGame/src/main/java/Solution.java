
/**
 *
 * https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
 *
 */
public class Solution {

    public int numberOfWeakCharacters(int[][] properties) {

        int maxSize = 100000;
        int weakCount = 0;
        int[] x = new int[maxSize+2];

        for(int i=0; i<properties.length; i++){
            x[properties[i][0]]=Math.max( x[properties[i][0]], properties[i][1]);
        }

        for(int i=maxSize; i>=0; i--){
            x[i]=Math.max(x[i] , x[i+1]);
        }

        for(int i=0; i<properties.length; i++){
            if(properties[i][1]<x[properties[i][0]+1]){
                weakCount++;
            }
        }

        return weakCount;

    }

}
