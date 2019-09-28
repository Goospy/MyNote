package com.goospy.leetcode;

/**
 * Created by Goospy on 2018/12/23.
 */
public class L44 {

    public boolean isMatch(String s, String p) {
        return match(s.toCharArray(), 0, s.length(), p.toCharArray(), 0, p.length());
    }

    public boolean match(char[] s, int i, int sLen, char[] p, int j, int pLen) {
        char cus = s[i];
        char cup = p[j];

        if(cup == '?') {
            if(i == sLen && j == pLen) {
                return true;
            }

            if(i < sLen && j < pLen) {
                return match(s, i+1, sLen, p, j+1, pLen);
            }

            return false;
        }
        if(cup == '?' && i == sLen && j == pLen) {
            return true;
        } else {
            return match(s, i+1, sLen, p, j+1, pLen);
        }

//        if(cup == '*' && i == sLen && j == pLen) {
//            return true;
//        } else {
//            return match(s, i+1, sLen, p, j, pLen) || match(s, i+1, sLen, p, j+1, pLen);
//        }

//        return cus == cup;
    }

}
