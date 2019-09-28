package com.goospy.leetcode;

/**
 * Created by Goospy on 2017/12/17.
 */
public class L33 {
    public static void main(String[] args) {
        System.out.println(L33.search(new int[]{3, 1}, 3));
    }
    public static int search(int[] nums, int target) {
        if(null == nums || 0 == nums.length) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[right]) {
                if(target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(nums[left] <= nums[mid]) {
                if(target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
