/**
 * Leetcode - median_of_two_sorted_arrays
 */
package com.leetcode.median_of_two_sorted_arrays;
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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double mid = 0;  double pre = 0;  int idx1 = 0;  int idx2 = 0; //line 1

        if(nums1.length == 0 && nums2.length == 1) return nums2[0]; //line 2
        if(nums2.length == 0 && nums1.length == 1) return nums1[0]; //line 3

        for(int i = 0; i<(nums1.length + nums2.length + 3)/2; i++){ //line 4
            pre = mid; //line 5
            if(idx1 == nums1.length) mid = nums2[idx2++]; //line 6
            else if(idx2 == nums2.length) mid = nums1[idx1++]; //line 7
            else if(nums1[idx1] <= nums2[idx2]) mid = nums1[idx1++]; //line 8
            else if(nums1[idx1] > nums2[idx2]) mid = nums2[idx2++]; //line 9
        }
        return (nums1.length + nums2.length)%2 == 1? pre : (pre + mid)/2; //line 10
    }

    public static void main(String[] args) {

        int[] n1 = {1, 3, 3, 10};
        int[] n2 = {4, 7, 9, 99};

        System.out.println(new Solution2().findMedianSortedArrays(n1, n2));
    }
}
