/**
 * Leetcode - number_of_valid_words_for_each_puzzle
 */
package com.leetcode.number_of_valid_words_for_each_puzzle;
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

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(String word: words) {
            int mask = 0;
            for(int i = 0; i < word.length(); i++) {
                mask |= (1 << (word.charAt(i) - 'a'));
            }
            if(Integer.bitCount(mask) <= 7) {
                counter.put(mask, counter.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(String puzzle: puzzles) {
            int mask = 0;
            for(int i = 1; i < 7; i++) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }

            int count = 0;
            int state = mask;
            int first = (1 << (puzzle.charAt(0) - 'a'));
            do {
                state = (state - 1) & mask;
                int s = state | first;
                count += counter.getOrDefault(s, 0);
            } while(state != mask);

            ans.add(count);
        }

        return ans;
    }

}
