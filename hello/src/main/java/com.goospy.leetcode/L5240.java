package com.goospy.leetcode;

import java.util.*;

/**
 * Created by Goospy on 2019/10/27 in Hong Xin Jin Fu
 */
public class L5240 {

    public static void main(String[] args) {
        L5240 l5240 = new L5240();
        System.out.println(l5240.maxLength(Arrays.asList("cha","r","act","ers")));
    }

    private int max = 0;

    public int maxLength(List<String> arr) {
        List<String> handledStrList = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        for(String s: arr) {
            if(!isRepeated(s, set)) {
                handledStrList.add(s);
            }

            set.clear();
        }

        if(handledStrList.isEmpty()) {
            return 0;
        }

        if(handledStrList.size() == 1) {
            return handledStrList.get(0).length();
        }

        dfs(arr, new HashSet<>(), 0);
        return max;
    }

    private void dfs(List<String> arr, Set<Character> set, int index) {
        if(index >= arr.size()) {
            if(max < set.size()) {
                max = set.size();
            }
            return;
        }

        for(int i = index; i < arr.size(); i++) {
            String cur = arr.get(index);
            Set<Character> newSet = new HashSet<>(set);
            if(!isRepeated(cur, newSet)) {
                dfs(arr, newSet, index + 1);
            }
            dfs(arr, set, index + 1);
        }
    }

    private boolean isRepeated(String s, Set<Character> set) {
        boolean isRepeated = false;
        for(char c: s.toCharArray()) {
            if(set.contains(c)) {
                isRepeated = true;
                break;
            } else {
                set.add(c);
            }
        }
        return isRepeated;
    }
}
