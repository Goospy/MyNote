package com.goospy.leetcode;

import java.util.Arrays;

public class L5090 {

    public double probabilityOfHeads(double[] prob, int target) {
        if(target > prob.length) {
            return 0;
        }
        double[][] dp = new double[prob.length + 1][target + 1];
        for(int i = 0; i <= prob.length; i++) {
            for(int j = 0; j <= target; j++) {
                dp[i][j] = -1d;
            }
        }
        return backTrace(prob, 0, target, 1, dp);
    }

    private double backTrace(double[] prob, int i, int target, double pos, double[][] dp) {
        if(i == prob.length) {
            double res = target == 0 ? pos : 0;
            dp[i][target] = res;
            return res;
        }

        if(-1d != dp[i][target]) {
            return dp[i][target];
        }

        if(target == 0) {
            return backTrace(prob, i+1, target, pos*(1 - prob[i]), dp);
        }
        double pos1 = backTrace(prob, i+1, target - 1, pos*prob[i], dp);
        dp[i + 1][target - 1] = pos1;
        double pos2 = backTrace(prob, i+1, target, pos*(1 - prob[i]), dp);
        dp[i + 1][target] = pos2;
        return pos1 + pos2;
    }

}
