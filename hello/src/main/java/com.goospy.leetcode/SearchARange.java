package com.goospy.leetcode;

/**
 * Created by Goospy on 2017/9/6.
 */
public class SearchARange {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8);
        for(int a: result) {
            System.out.println(a);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            if(nums[left] == target && nums[right] == target) {
                return new int[]{left, right};
            }

            if(nums[left] == target) {
                right--;
                continue;
            }

            if(nums[right] == target) {
                left++;
                continue;
            }

            left++;
            right--;
        }

        if((left == right) && (nums[left] == target)) {
            return new int[]{left, right};
        }

        return new int[]{-1, -1};
    }
}
