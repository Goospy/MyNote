package com.goospy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Goospy on 2019/10/6 in Hong Xin Jin Fu
 */
public class L5216 {

    private List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public int countVowelPermutation(int n) {
        if(n == 1) {
            return 5;
        }

        Map<Character, List<Character>> characterListMap = new HashMap<>();
        characterListMap.put('a', Arrays.asList('e'));
        characterListMap.put('e', Arrays.asList('a', 'i'));
        characterListMap.put('i', Arrays.asList('a', 'e', 'o', 'u'));
        characterListMap.put('o', Arrays.asList('i', 'u'));
        characterListMap.put('u', Arrays.asList('a'));

        Map<Character, Long> cur = new HashMap<>();
        for(Character c: characters) {
            cur.put(c, 1l);
        }

        Map<Character, Long> next = new HashMap<>();
        for(int i = 1; i < n; i++) {
            for(Character c: characters) {
                long count = cur.get(c);
                List<Character> nextList = characterListMap.get(c);
                for(char nextChar: nextList) {
                    next.put(nextChar, next.getOrDefault(nextChar, 0l) + count);
                }
            }
            cur = next;
            next = new HashMap<>();
        }

        long result = 0l;
        for(Character c: characters) {
            result += cur.get(c);
            result = result % (1000000007);
        }
        return (int) result;
    }

}
