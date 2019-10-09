package com.goospy.leetcode;

/**[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
 5
 * Created by Goospy on 2019/10/2 in Hong Xin Jin Fu
 */
public class L378 {

    public static void main(String[] args) {
        L378 l378 = new L378();
//        int[][] ma = {{3, 8, 8}, {3, 8, 8}, {3, 9, 13}};
        int[][] ma = {{1,4,7,11,15},
                      {2,5,8,12,19},
                      {3,6,9,16,22},
                      {10,13,14,17,24},
                      {18,21,23,26,30}};
        System.out.println(l378.kthSmallest(ma, 5));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int[] colIdx = new int[len];
        for(int i = 1; i <= k; i++) {
            int minIdx = 0;
            int minVal = Integer.MAX_VALUE;
            for(int j = 0; j < len; j++) {
                int col = colIdx[j];
                if(col < len && minVal >= matrix[j][col]) {
                    minIdx = j;
                    minVal = matrix[j][col];
                }
            }
            colIdx[minIdx]++;

            if(i == k) {
                return minVal;
            }
        }
        return 0;
    }

}
