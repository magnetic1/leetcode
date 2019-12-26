/**
 * Leetcode - median_of_two_sorted_arrays
 */
package com.leetcode.median_of_two_sorted_arrays;

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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length, N = nums2.length;
        int[] nums = new int[M + N];
        int i = 0, j = 0;
        while (i < M && j < N) {
            if (nums1[i] < nums2[j]) {
                nums[i + j] = nums1[i];
                i++;
            } else {
                nums[i + j] = nums2[j];
                j++;
            }
        }
        while (i < M) {
            nums[i + j] = nums1[i];
            i++;
        }
        while (j < N) {
            nums[i + j] = nums2[j];
            j++;
        }

        if ((M + N) % 2 == 1) {
            return nums[(M + N) / 2];
        }
        return (nums[(M + N) / 2] + nums[(M + N) / 2 - 1]) / 2.0;

    }


    public static void main(String[] args) {
        int[] n1 = {1,3};
        int[] n2 = {2};

        System.out.println(new Solution1().findMedianSortedArrays(n1, n2));

    }

}
