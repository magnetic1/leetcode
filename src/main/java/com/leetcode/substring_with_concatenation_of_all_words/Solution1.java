/**
 * Leetcode - substring_with_Concatenation_of_all_words
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
class Solution1 implements Solution {

    Set<Integer> resultSet = new HashSet<>();

    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length <= 0) {
            return new ArrayList<>();
        }
        int wordLength = words[0].length();


        int index = s.indexOf(words[0]);
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(words[0]);
        java.util.regex.Matcher matcher = pattern.matcher(s);
        if (wordLength < 10) {
            while (index >= 0) {
                Set<Integer> set = new HashSet<>();
                set.add(0);
                findConcatenation(index, index + wordLength, wordLength, words, s, set);


                index = s.indexOf(words[0], index + 1);
            }
        } else {
            while (matcher.find()) {
                index = matcher.start();
                Set<Integer> set = new HashSet<>();
                set.add(0);
                findConcatenation(index, index + wordLength, wordLength, words, s, set);
            }
        }


        return new ArrayList<>(resultSet);
    }

    private void findConcatenation(int lo, int hi, int wordLength, String[] words, String s, Set<Integer> exits) {
//        int count = 1;

        if (exits.size() != words.length) {
            if (lo - wordLength >= 0) {
                String loWord = s.substring(lo - wordLength, lo);
                for (int i = 1; i < words.length; i++) {
                    if (!exits.contains(i) && loWord.equals(words[i])) {
                        exits.add(i);
                        findConcatenation(lo - wordLength, hi, wordLength, words, s, exits);
                        // 移除第i个word
                        exits.remove(i);
                        break;
                    }
                }
            }

            if (hi + wordLength <= s.length()) {
                String hiWord = s.substring(hi, hi + wordLength);
                for (int i = 1; i < words.length; i++) {
                    if (!exits.contains(i) && hiWord.equals(words[i])) {
                        exits.add(i);
                        findConcatenation(lo, hi + wordLength, wordLength, words, s, exits);
                        exits.remove(i);
                        break;
                    }
                }
            }

        } else {
            resultSet.add(lo);
        }

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};

        System.out.println(solution1.findSubstring(s, words));
    }

}
