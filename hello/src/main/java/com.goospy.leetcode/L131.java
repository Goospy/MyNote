package com.goospy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrace(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backTrace(List<List<String>> result, List<String> list, String s, int start) {
        if(start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i);
            if(isPalindrome(subStr)) {
                list.add(subStr);
                backTrace(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
