package com.goospy.leetcode;

/**
 * Created by Goospy on 2018/1/6.
 */
public class L35 {

    public static int candy(int[] ratings) {
        int childs = ratings.length;
        boolean[] given = new boolean[childs];
        int[] amount = new int[childs];

        given[0] = true;
        amount[0] = 1;

        given[childs - 1] = true;
        amount[childs - 1] = 1;

        int leftBorder = 1;
        int rightBorder = ratings.length - 1;
        while(!isAllGiven(given)) {
            for(int i = leftBorder; i < rightBorder; i++) {
                int left = ratings[i - 1];
                int mid = ratings[i];
                int right = ratings[i + 1];

                if(mid <= left && mid <= right) {
                    if(mid == left && given[i - 1]) {
                        amount[i] = amount[i - 1];
                        given[i] = true;
                        continue;
                    }

                    if(mid == right && given[i + 1]) {
                        amount[i] = amount[i + 1];
                        given[i] = true;
                        continue;
                    }

                    amount[i] = 1;
                    given[i] = true;
                    continue;
                }

                if(mid < right && given[i - 1]) {
                    amount[i] = mid == left ? amount[i - 1] : amount[i - 1] + 1;
                    given[i] = true;
                }

                if(mid < left && given[i + 1]) {
                    amount[i] = mid == right ? amount[i + 1] : amount[i + 1] + 1;
                    given[i] = true;
                }
            }
        }

        if(ratings[0] >= ratings[1]) {
            amount[0] = amount[1] + 1;
        }

        return -1;
    }

    private static boolean isAllGiven(boolean[] given) {
        for(boolean bo: given) {
            if(!bo) {
                return false;
            }
        }

        return true;
    }
}
