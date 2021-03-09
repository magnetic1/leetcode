/**
 * Leetcode - remove_all_adjacent_duplicates_in_string
 */
package com.leetcode.remove_all_adjacent_duplicates_in_string;
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

    public String removeDuplicates(String S) {
        Deque<Character> deque = new LinkedList<>();

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(deque.isEmpty() || !deque.peek().equals(c)) {
                deque.push(c);
            } else {
                deque.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }

        return sb.toString();
    }

}
