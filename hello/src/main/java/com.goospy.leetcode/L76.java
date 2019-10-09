package com.goospy.leetcode;

import java.util.*;

/**
 * Created by Goospy on 2019/10/2 in Hong Xin Jin Fu
 */
public class L76 {

    private Map<Character, Integer> window = new HashMap<>();

    private Map<Character, Integer> needs = new HashMap<>();

    public static void main(String[] args) {
        L76 l76 = new L76();
        String res = l76.minWindow("aab", "aab");
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        boolean existsMatch = false;
        int left = 0, right = 0, match = 0, minLen = s.length(), minIdx = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            Integer count = needs.get(c);
            if(null != count) {
                Integer winc = window.getOrDefault(c, 0) + 1;
                window.put(c, winc);
                if(winc.intValue() == count.intValue()) {
                    match++;
                }
            }
            right++;

            while(match == needs.size()) {
                existsMatch = true;
                int curLen = right - left;
                if(curLen < minLen) {
                    minLen = curLen;
                    minIdx = left;
                }

                char le = s.charAt(left);
                Integer ne = needs.get(le);
                if(null != ne) {
                    Integer winc = window.get(le) - 1;
                    window.put(le, winc);
                    if(winc.intValue() < ne.intValue()) {
                        match--;
                    }
                }
                left++;
            }
        }

        if(!existsMatch) {
            return "";
        }
        return s.substring(minIdx, minIdx + minLen);
    }

}
