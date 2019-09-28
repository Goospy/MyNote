package com.goospy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(null == nums || 0 == nums.length) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque();

        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if(i >= k - 1) {
                result[idx++] = nums[deque.peek()];
            }
        }
        return result;
    }

}
