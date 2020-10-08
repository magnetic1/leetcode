/**
 * Leetcode - number_of_ways_where_square_of_number_is_equal_to_product_of_two_numbers
 */
package com.leetcode.number_of_ways_where_square_of_number_is_equal_to_product_of_two_numbers;
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

    public int numTriplets(int[] nums1, int[] nums2) {
        int[] s = new int[100_001];

        int ans = 0;
        for (int k : nums2) {
            s[k] += 1;
        }
        for (int k : nums1) {
            long now = (long) k * k;
            for (int i : nums2) {
                if (now % i == 0) {
                    long c = now / i;
                    if (c <= 100_000) {
                        if (i == c) {
                            ans += s[(int) c] - 1;
                        } else {
                            ans += s[(int) c];
                        }
                    }
                }
            }
        }

        for (int k : nums2) {
            s[k]--;
        }
        for (int k : nums1) {
            s[k]++;
        }
        for (int k : nums2) {
            long now = (long) k * k;
            for (int i : nums1) {
                if (now % i == 0) {
                    long c = now / i;
                    if (c <= 100_000) {
                        if (i == c) {
                            ans += s[(int) c] - 1;
                        } else {
                            ans += s[(int) c];
                        }
                    }
                }
            }
        }
        return ans / 2;
    }

}
