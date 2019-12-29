package com.goospy.leetcode;

/**
 * Created by Goospy on 2019/10/6 in Hong Xin Jin Fu
 */
public class L5214 {

    public int longestSubsequence(int[] arr, int difference) {
        int longest = 1;
        for(int i = 0; i < arr.length; i++) {
            int next = arr[i] + difference;
            int count = 1;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] == next) {
                    count++;
                    next = next + difference;
                }
            }
            if(count > longest) {
                longest = count;
            }
        }
        return longest;
    }

}
