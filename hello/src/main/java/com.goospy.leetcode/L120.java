package com.goospy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Goospy on 2019/9/25.
 */
public class L120 {

    public static void main(String[] args) {
        L120 l120 = new L120();
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8,3));
        l120.minimumTotal(lists);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];

        for(List<Integer> row: triangle) {
            for(int i = row.size() - 1; i >= 0; i--) {
                int cum = (i == 0 ? dp[i] : ((i == row.size() - 1) ? dp[i - 1] : Math.min(dp[i], dp[i - 1]))) + row.get(i);
                dp[i] = cum;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int val: dp) {
            if(val < min) {
                min = val;
            }
        }
        return min;
    }

}
