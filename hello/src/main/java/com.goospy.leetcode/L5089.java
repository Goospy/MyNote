package com.goospy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L5089 {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        for(int[] arr1: slots1) {
            int left = arr1[0];
            int right = arr1[1];
            for(int[] arr2: slots2) {
                if(left >= arr2[1] || right <= arr2[0]) {
                    continue;
                }

                int bothLeft = Math.max(left, arr2[0]);
                int bothRight = Math.min(right, arr2[1]);
                int tempDura = bothRight - bothLeft;
                if(tempDura >= duration) {
                    result.add(bothLeft);
                    result.add(bothLeft + duration);
                    return result;
                }
            }
        }
        return result;
    }

}
