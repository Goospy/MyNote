package com.goospy.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Goospy on 2019/10/4 in Hong Xin Jin Fu
 */
public class L55 {

    public static void main(String[] args) {
        new L55().canJump(new int[]{1, 1, 0, 1});
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] enqued = new boolean[nums.length];

        for(int i = 1; i <= nums[0] && i < nums.length; i++) {
            queue.add(i);
            enqued[i] = true;
        }

        while(!queue.isEmpty()) {
            int curIdx = queue.poll();
            if(curIdx == nums.length - 1) {
                return true;
            }
            for(int i = 1; i <= nums[curIdx] && i < nums.length; i++) {
                if(curIdx + i >= nums.length - 1) {
                    return true;
                }

                if(!enqued[curIdx + i]) {
                    queue.add(curIdx + i);
                }
            }
        }
        return false;
    }

}
