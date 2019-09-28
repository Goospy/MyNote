package com.goospy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Goospy on 2019/9/28.
 */
public class L15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if(null == nums || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];

            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                int twoSum = nums[j] + nums[k];
                if(twoSum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                } else if(twoSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return result;
    }

}
