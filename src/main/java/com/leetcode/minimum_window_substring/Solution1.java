/**
 * Leetcode - minimum_window_substring
 */
package com.leetcode.minimum_window_substring;
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

    public String minWindow(String s, String t) {
        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();

        int left = 0, right = 0, n = sArray.length, m = tArray.length;
        int min = Integer.MAX_VALUE;

        // Map<Character, Integer> map = new HashMap<>();
        int[] map = new int[256];
        int num = 0;
        for (char c : tArray) {
            int last = map[c];
            if (last == 0) {
                num++;
            }
            map[c] = last + 1;
        }

        int l = 0, r = 0;
        while(right < n) {
            char c = sArray[right];
            int last = map[c];
            if(last == 1) {
                num--;
            }
            map[c] = last - 1;

            while(num == 0) {
                if(right - left + 1 < min) {
                    min = right - left + 1;
                    l = left;
                    r = right;
                }
                char lc = sArray[left];
                int count = map[lc];
                if(count == 0) {
                    num++;
                }
                map[lc] = count + 1;

                left++;
            }
            right++;
        }


        if(min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(l, r + 1);
        }
    }

}
