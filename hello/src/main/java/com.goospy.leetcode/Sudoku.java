package com.goospy.leetcode;

/**
 * Created by Goospy on 2017/11/26.
 */
public class Sudoku {

    private char[] elements = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private char emptyEle = '.';

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            char[] row = board[i];

            for(int j = 0; j < row.length; j++) {
                char cell = row[j];
                if(cell == emptyEle) {
                    for(char ele: elements) {
                        if(!isColRepeated(ele, j, board) && !isRowRepeated(ele, row)) {
                            board[i][j] = ele;
                            if(!isValidSudoku(board)) {
                               return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean isColRepeated(char ele, int col, char[][] board) {
        for(int i = 0; i < board.length; i++) {
            char[] row = board[i];

            for(int j = 0; j < row.length; j++) {
                if(col == j && row[j] == ele) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isRowRepeated(char ele, char[] row) {
        for(char cell: row) {
            if(cell == ele) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
        Sudoku sudoku = new Sudoku();
        System.out.println(sudoku.isValidSudoku(board));
    }
}
