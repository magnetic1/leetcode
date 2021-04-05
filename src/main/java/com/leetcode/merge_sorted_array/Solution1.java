/**
 * Leetcode - merge_sorted_array
 */
package com.leetcode.merge_sorted_array;
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

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];

        for (int i = 0; i < m; i++) {
            tmp[i] = nums1[i];
        }

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (tmp[i] < nums2[j]) {
                nums1[k] = tmp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            nums1[k] = tmp[i];
            i++;
            k++;
        }
        while (j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }

    }

}
