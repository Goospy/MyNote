package com.goospy.leetcode;

/**
 * Created by Goospy on 2019/10/13 in Hong Xin Jin Fu
 */
public class L5222 {

    public static void main(String[] args) {
        System.out.println(new L5222().balancedStringSplit("RLRRRLRLLL"));
    }

    public int balancedStringSplit(String s) {
        int rCount = 0, maxR = 0;
        int lCount = 0, maxL = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == 'R') {
                rCount++;
                if(rCount > maxR) {
                    maxR = rCount;
                }
                lCount = 0;
            } else {
                lCount++;
                if(lCount > maxL) {
                    maxL = lCount;
                }
                rCount = 0;
            }
        }
        return s.length() - Math.min(maxL, maxR);
    }

}
