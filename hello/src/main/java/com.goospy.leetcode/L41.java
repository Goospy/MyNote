package com.goospy.leetcode;

/**
 * Created by Goospy on 2018/11/24.
 */
public class L41 {

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean[] appeared = new boolean[length];
        for(int i = 0; i < length; i++) {
            int cur = nums[i];
            if(cur > length || cur < 1) {
                continue;
            }

            appeared[cur - 1] = true;
        }

        for(int i = 0; i < length; i++) {
            if(!appeared[i]) {
                return i + 1;
            }
        }
        return length + 1;
    }

}
