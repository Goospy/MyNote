package com.goospy.leetcode;

/**
 * Created by Goospy on 2019/10/6 in Hong Xin Jin Fu
 */
public class L5215 {

    private int[] row = new int[]{0, -1, 0, 1};

    private int[] col = new int[]{1, 0, -1, 0};

    private int max = 0;

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(new L5215().getMaximumGold(grid));
    }

    public int getMaximumGold(int[][] grid) {
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0 && !used[i][j]) {
                    dfs(grid, i, j, used, 0);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] used, int count) {
        if(0 <= x && x < grid.length && 0 <= y && y < grid[0].length && !used[x][y] && grid[x][y] != 0) {
            count += grid[x][y];
            if(count > max) {
                max = count;
            }
            used[x][y] = true;
            for(int i = 0; i < 4; i++) {
                dfs(grid, x + row[i], y + col[i], used, count);
            }
            used[x][y] = false;
        }
    }

}
