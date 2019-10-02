package com.goospy.leetcode;

import java.util.Arrays;
import java.util.Random;

public class L398 {

    private int[] nums;

    private Random random = new Random();

    public L398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int result = -1;
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                int r = random.nextInt(j + 1);
                if (r < 1) {
                    result = i;
                }
                j++;
            }
        }
        return result;
    }

}
