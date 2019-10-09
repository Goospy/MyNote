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
        if(s.equals("0")) {
            return 0;
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean lastZeroGet = false;
        for(int i = 0; i < s.length(); i++) {

        }
        s = s.substring(s.indexOf('0'), s.lastIndexOf('0'));
        count(0, s);
        return count;
    }

    private void count(int cur, String s) {
        if(cur == s.length()) {
            count++;
            return ;
        }

        count(cur+1, s);

        if(cur < s.length() - 1) {
            String sub = s.substring(cur, cur + 2);
            if(sub.compareTo("11") >= 0 && sub.compareTo("26") <= 0 && !sub.equals("20")) {
                count(cur+2, s);
            }
        }
    }

}
