/**
 * Leetcode - palindrome_number
 */
package com.leetcode.palindrome_number;
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
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int reverse = 0, order = x;
        while (x != 0) {
            reverse = reverse * 10 + (x % 10);
            x = x / 10;
        }
        return reverse == order;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isPalindrome(-121));
    }
}
