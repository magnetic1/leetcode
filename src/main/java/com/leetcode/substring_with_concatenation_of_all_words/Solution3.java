package com.leetcode.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int size = words.length;
        if (size == 0) return ret;
        int wordLen = words[0].length();
        int window = size * wordLen;
        int sLen = s.length();
        char[] ca = s.toCharArray();
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String w : words)
            wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
        for (int i = 0; i < wordLen; i++) {

            for (int j = i; j + window <= sLen; j += wordLen) {

                Map<String, Integer> map = new HashMap<>();
                for (int k = size - 1; k >= 0; k--) {
                    String word = new String(ca, j + k * wordLen, wordLen);
                    int cnt = map.getOrDefault(word, 0) + 1;
                    if (cnt > wordsMap.getOrDefault(word, 0)) {
                        j += k * wordLen;
                        break;
                    } else if (k == 0)
                        ret.add(j);
                    else
                        map.put(word, cnt);
                }
            }
        }
        return ret;
    }
}
