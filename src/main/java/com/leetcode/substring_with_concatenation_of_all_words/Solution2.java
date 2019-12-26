/**
 * Leetcode - substring_with_concatenation_of_all_words
 */
package com.leetcode.substring_with_concatenation_of_all_words;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();

        if (words == null || words.length <= 0) {
            return resultList;
        }

        int wordLength = words[0].length();

        if (s.length() < wordLength) {
            return resultList;
        }

        int totalLength = wordLength * words.length;
        char[] ca = s.toCharArray();
        Map<String, Integer> wordCountMap = new HashMap<>();
        Map<String, Integer> tempWordCountMap = new HashMap<>();
        for (String word : words) {
            if (!wordCountMap.containsKey(word)) {
                wordCountMap.put(word, 1);
                tempWordCountMap.put(word, 0);
            } else {
                wordCountMap.computeIfPresent(word, (key, oldValue) -> oldValue + 1);
            }
        }

        for (int i = 0; i < wordLength; i++) {
            int lo = i, hi = i + wordLength;

            while (hi <= s.length() && lo + totalLength <= s.length()) {
//                String cur = s.substring(hi - wordLength, hi);
                String cur = new String(ca, hi - wordLength, wordLength);
                if (wordCountMap.containsKey(cur) && tempWordCountMap.get(cur) < wordCountMap.get(cur)) {
                    // tempWordCountMap[cur]++
                    tempWordCountMap.computeIfPresent(cur, (key, oldValue) -> oldValue + 1);
                } else {
                    while (lo < hi) {
//                        String pre = s.substring(lo, lo + wordLength);
                        String pre = new String(ca, lo, wordLength);
                        lo += wordLength;
                        // 如果为true，此时可以不用tempWordCountMap[pre]--，因为减掉的pre与加入的cur相同
                        if (pre.equals(cur)) {
                            break;
                        }
                        // tempWordCountMap[pre]--
                        tempWordCountMap.computeIfPresent(pre, (key, oldValue) -> oldValue - 1);
                    }
                }

//                System.out.println(lo + ", " + hi);
//                tempWordCountMap.forEach((s1, integer) -> System.out.println(s1 + ", " + integer));
                if (hi - lo == totalLength) {
                    resultList.add(lo);
                }

                hi += wordLength;
            }

            tempWordCountMap.forEach((word, count) -> tempWordCountMap.put(word, 0));
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        String s = "aaaaaaaa";
        String[] words = {"aa","aa","aa"};

        System.out.println(solution2.findSubstring(s, words));
    }

}
