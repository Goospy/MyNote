package com.goospy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Goospy on 2018/11/25.
 */
public class L39 {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        L39 l39 = new L39();
        l39.combinationSum(new int[]{2, 3, 5}, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for(int k = 0; k < candidates.length; k++) {
            reduce(new ArrayList<Integer>(), k, candidates, target);
        }
        return res;
    }

    private void reduce(List<Integer> result, int k, int[] candidates, int target) {
        int length = candidates.length;
        int cur = candidates[k];
        if(target == cur) {
            List<Integer> list = new ArrayList<Integer>();
            list.addAll(result);
            list.add(cur);
            res.add(list);
            return;
        }

        for(int i = k; i < length; i++) {
            int newT = target - cur;
            if (newT > 0) {
                result.add(cur);
                reduce(result, i, candidates, newT);
                result.remove(result.size() - 1);
            }
        }
    }

}
