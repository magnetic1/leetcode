/**
 * Leetcode - longest_substring_with_at_least_k_repeating_characters
 */
package com.leetcode.longest_substring_with_at_least_k_repeating_characters;
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

    public int longestSubstring(String s, int k) {
        char[] charArray = s.toCharArray();
        return longestSubstring(charArray, 0, charArray.length - 1, k);
    }

    int longestSubstring(char[] charArray, int l, int r, int k) {
        if(r - l + 1 < k) {
            return 0;
        }
        int[] counts = new int[26];
        for(int i = l; i <= r; i++) {
            counts[charArray[i] - 'a'] += 1;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r; i++) {
            if(counts[charArray[i] - 'a'] < k) {
                list.add(i);
            }
        }

        if(list.size() == 0) {
            return r - l + 1;
        }

        int max = 0;
        max = Math.max(max, longestSubstring(charArray, l, list.get(0) - 1, k));
        for(int i = 1; i < list.size(); i++) {
            max = Math.max(max, longestSubstring(charArray, list.get(i - 1) + 1, list.get(i) - 1, k));
        }
        max = Math.max(max, longestSubstring(charArray, list.get(list.size() - 1) + 1, r, k));

        return max;
    }

}
