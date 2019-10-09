package com.goospy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Goospy on 2019/10/2 in Hong Xin Jin Fu
 */
public class L387 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(countMap.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

}
