package com.goospy.leetcode;

import com.goospy.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class L78 {

    public static void main(String[] args) {
        L78 l78 = new L78();
        l78.subsets(new int[]{1, 2, 3}).stream().forEach(ListUtil::showList);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void recursion(List<List<Integer>> result, List<Integer> cur, int[] nums, int start) {
        result.add(new ArrayList<>(cur));
        if(start >= nums.length) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            recursion(result, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
