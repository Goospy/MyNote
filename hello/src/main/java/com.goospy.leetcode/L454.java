package com.goospy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for(int a: A) {
            for (int b: B) {
                int temp = a + b;
                sumMap.put(a+b, sumMap.getOrDefault(temp, 0) + 1);
            }
        }

        int res = 0;
        for(int c: C) {
            for(int d: D) {
                res += sumMap.getOrDefault(-(c+d), 0);
            }
        }
        return res;
    }

}
