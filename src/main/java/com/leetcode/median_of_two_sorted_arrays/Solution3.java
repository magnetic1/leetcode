package com.leetcode.median_of_two_sorted_arrays;

public class Solution3 implements Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length;
        int N = nums2.length;
        if (M > N) {
            int[] temps = nums1;
            nums1 = nums2;
            nums2 = temps;
            int temp = M;
            M = N;
            N = temp;
        }

        int iMin = 0, iMax = M, halfLen = (M + N + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ( (M + N) % 2 == 1 ) {
                    return maxLeft;
                }

                int minRight;
                if (i == M) {
                    minRight = nums2[j];
                } else if (j == N) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] i1 = {1,3};
        int[] i2 = {2};

        System.out.println(new Solution3().findMedianSortedArrays(i1, i2));
    }
}
