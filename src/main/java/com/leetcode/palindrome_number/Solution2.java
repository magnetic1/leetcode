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
class Solution2 implements Solution {
    private static int[] ints =
            {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999
                    , 999999999, Integer.MAX_VALUE};

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int i = 0, j = 0;
        while (x > ints[i]) {
            i++;
        }
        while (i > j) {
            int m = (x % (ints[j] + 1)) * 10 / (ints[j] + 1);
            int n = (x / (ints[i - 1] + 1)) % 10;
            if (n != m) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isPalindrome(1001));
    }
}
