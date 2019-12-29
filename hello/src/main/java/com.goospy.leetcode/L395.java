package com.goospy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Goospy on 2019/10/2 in Hong Xin Jin Fu
 */
public class L395 {

    public int longestSubstring(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.contains("");
        set.remove("");
        Object a = set.toArray()[0];

        char[] chars = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            if(count(chars, chars[i]) < k) {
                String[] strings = s.split(chars[i] + "");
                int max = 0;
                for(String s1: strings) {
                    int res = longestSubstring(s1, k);
                    if(res > max) {
                        max = res;
                    }
                }
                return max;
            }
        }
        return s.length();
    }

    public int count(char[] s, char c) {
        int count = 0;
        for(char a: s) {
            if(a == c) {
                count++;
            }
        }
        return count;
    }

}
