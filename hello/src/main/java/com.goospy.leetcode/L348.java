package com.goospy.leetcode;

/**
 * Created by Goospy on 2019/10/4 in Hong Xin Jin Fu
 */
public class L348 {
    int[][] play;

    int n;

    /** Initialize your data structure here. */
    public L348(int n) {
        play = new int[n][n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        play[row][col] = player;
        boolean rowMatch = true;
        boolean colMatch = true;
        for(int i = 0; i < n; i++) {
            if(rowMatch && play[row][i] != player) {
                rowMatch = false;
            }

            if(colMatch && play[i][col] != player) {
                colMatch = false;
            }
        }
        if(rowMatch || colMatch) {
            return player;
        }

        if(row == col) {
            boolean naMatch = true;
            for(int i = 0; i < n; i++) {
                if(naMatch && play[i][i] != player) {
                    naMatch = false;
                    break;
                }
            }

            if(naMatch) {
                return player;
            }
        }

        if(row + col == n - 1) {
            boolean pieMatch = true;
            for(int i = 0; i < n; i++) {
                if(pieMatch && play[n - 1 - i][i] != player) {
                    pieMatch = false;
                    break;
                }
            }

            if(pieMatch) {
                return player;
            }
        }

        return 0;
    }

}
