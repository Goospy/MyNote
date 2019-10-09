package com.goospy.leetcode;

import com.goospy.util.ArrayUtil;

/**
 * Created by Goospy on 2019/10/4 in Hong Xin Jin Fu
 */
public class L73 {

    public static void main(String[] args) {
        L73 l73 = new L73();
        int[][] arr = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        l73.setZeroes(arr);
        ArrayUtil.showArray(arr);
    }

    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        boolean[] toZero = new boolean[rowLen + matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    toZero[i] = true;
                    toZero[rowLen+j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(toZero[i] || toZero[rowLen+j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
