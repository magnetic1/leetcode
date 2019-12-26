/**
 * Leetcode - first_missing_positive
 */
package com.leetcode.first_missing_positive;

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
class Solution1 implements Solution {
    public int firstMissingPositive(int[] nums) {

        boolean[] booleans = new boolean[nums.length];

        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                booleans[num - 1] = true;
            }
        }

        for (int i = 0; i < booleans.length; i++) {
            if (!booleans[i]) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

}
