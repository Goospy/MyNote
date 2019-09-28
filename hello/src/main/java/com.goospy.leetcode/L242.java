package com.goospy.leetcode;

public class L242 {

    public static void main(String[] args) {
        isAnagram("a", "b");
    }

    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        count[1] = count[1] + 1;
        for(char c: s.toCharArray()) count[c] = count[c]++;
        for(char c: t.toCharArray()) count[c] = count[c]--;
        for(int i: count) if(i != 0) return false;
        return true;
    }

}
