package com.goospy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Goospy on 2019/12/29 in Hong Xin Jin Fu
 */
public class L5298 {

    public boolean isSolvable(String[] words, String result) {
        boolean[] used = new boolean[10];
        Map<Character, Integer> valMap = new HashMap<>();



        return true;
    }

    private boolean dfs(String[] words, int wordIdx, StringBuilder stringBuilder, int idx, boolean[] used, Map<Character, Integer> valMap, Map<Integer, Character> npValMap, List<String> resultList, String result) {
        if(wordIdx >= words.length) {
            int res = 0;
            for(String s: resultList) {
                res += Integer.parseInt(s);
            }
            String resStr = res + "";
            if(resStr.length() != result.length()) {
                return false;
            }

            List<Integer> resetIdxList = new ArrayList<>();
            for(int i = 0; i < resStr.length(); i++) {
                Character character = npValMap.get(resStr.charAt(i));
                if(null == character) {
                    if(used[resStr.charAt(i) - '0']) {
                        return false;
                    }
                    used[resStr.charAt(i) - '0'] = true;
                    resetIdxList.add(resStr.charAt(i) - '0');
                } else {
                    if(character != result.charAt(i)) {
                        for(Integer j: resetIdxList) {
                            used[j] = false;
                        }
                        return false;
                    }
                }
            }
            return true;
        }
        String word = words[wordIdx];
        for(int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            Integer val = valMap.get(c);
            if(null != val) {
                stringBuilder.append(val);
            } else {
                int startIdx = (0 == i) ? 1 : 0;
                while(startIdx < used.length) {
                    if(!used[startIdx]) {
                        used[startIdx] = true;
                        valMap.put(c, startIdx);
                        npValMap.put(startIdx, c);
                        boolean res = dfs(words, wordIdx, stringBuilder, i, used, valMap, npValMap, resultList, result);
                        if(res) {
                            return true;
                        }
                        used[startIdx] = false;
                        valMap.remove(c);
                        npValMap.remove(startIdx);
                    }
                    startIdx++;
                }
            }
        }

        resultList.add(stringBuilder.toString());
        return dfs(words, wordIdx + 1, new StringBuilder(), 0, used, valMap, npValMap, resultList, result);
    }

}
