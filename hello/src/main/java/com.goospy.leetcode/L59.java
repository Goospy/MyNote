package com.goospy.leetcode;

/**
 * Created by Goospy on 2019/4/1.
 */
public class L59 {

    public static void main(String[] args) {
        L59.generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int sqr = n*n;
        int row = 0, col = 0;
        int minRow = 0, maxRow = n - 1, minCol = 0, maxCol = n - 1;

        int type = 0;
        int[][] result = new int[n][n];

        for(int i = 1; i <= sqr; i++) {
            result[row][col] = i;
            if(0 == type) {
                if(col > maxCol) {
                    type = 1;
                    row = row + 1;
                    col = maxCol;
                    minRow = minRow + 1;
                    continue;
                } else {
                    col++;
                }
            }

            if(1 == type) {
                if(row > maxRow) {
                    type = 2;
                    col = col - 1;
                    row = maxRow;
                    maxCol = maxCol - 1;
                    continue;
                } else {
                    row++;
                }
            }

            if(2 == type) {
                if(col < minCol) {
                    type = 3;
                    row = row - 1;
                    col = minCol;
                    maxRow = maxRow - 1;
                    continue;
                } else {
                    col--;
                }
            }

            if(3 == type) {
                if(row < minRow) {
                    type = 0;
                    col = col + 1;
                    row = minRow;
                    minCol = minCol + 1;
                    continue;
                } else {
                    row--;
                }
            }
        }

        return result;
    }

}
