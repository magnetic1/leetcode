/**
 * Leetcode - permutation_sequence
 */
package com.leetcode.permutation_sequence;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        int permSum = 1;
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
            permSum *= (i + 1);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 0; i < n; i++) {
            permSum = permSum / (n - i);
            int selected = k / permSum;
            sb.append(num[selected]);
            for (int j = selected; j < n - i - 1; j++) {
                num[j] = num[j + 1];
            }
            k = k % permSum;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.getPermutation(4, 9));
    }
}
