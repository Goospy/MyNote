package com.goospy.leetcode;

import com.goospy.util.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Goospy on 2019/10/3 in Hong Xin Jin Fu
 */
public class L438 {

    public static void main(String[] args) {
        L438 l438 = new L438();
        ListUtil.showList(l438.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, match = 0;
        while(right < s.length()) {
            char ri = s.charAt(right);
            Integer ne = needs.get(ri);
            if(null != ne) {
                window.put(ri, window.getOrDefault(ri, 0) + 1);
                if(ne.intValue() == window.get(ri)) {
                    match++;
                }
            }
            right++;

            while(match == needs.size()) {
                if(p.length() == (right - left)) {
                    result.add(left);
                }

                char le = s.charAt(left);
                Integer nel = needs.get(le);
                if(null != nel) {
                    window.put(le, window.get(le) - 1);
                    if(nel.intValue() > window.get(le)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return result;
    }

}
