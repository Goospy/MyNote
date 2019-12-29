package com.goospy.leetcode;

/**
 * Created by Goospy on 2019/10/5 in Hong Xin Jin Fu
 */
public class L91 {

    private int count = 0;

    public static void main(String[] args) {
        L91 l91 = new L91();
        System.out.println(l91.numDecodings("10"));
    }

    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, cur = 1;
        for(int i = 1; i < s.length(); i++) {
            int temp = cur;
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    cur = pre;
                } else {
                    return 0;
                }
            } else if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6' && s.charAt(i) >= '0')) {
                cur = cur + pre;
            }
            pre = temp;
        }

        return cur;
    }

}
