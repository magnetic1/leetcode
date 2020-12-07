/**
 * Leetcode - create_maximum_number
 */
package com.leetcode.create_maximum_number;

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

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        long maxNumber = 0;
        int m = nums1.length, n = nums2.length;

        int len1 = Math.min(m, k);
        int len2 = Math.min(n, k);
        int[] stack1 = getStack(nums1, len1);
        int[] stack2 = getStack(nums2, len2);

        for(int i = 0; i <= len1; i++) {
            int j = k - i;
            if (i <= len1 && j <= len2) {
                int[] s1 = getStack(nums1, i);
                int[] s2 = getStack(nums2, j);
                int[] s = merge(s1, s2);
                if(compare(res, 0, s, 0) < 0) {
                    res = s;
                }
            }
        }

        return res;
    }

    int[] getStack(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    int[] merge(int[] stack1, int[] stack2) {
        int m = stack1.length, n = stack2.length;
        int len = m + n;
        if(m == 0) {
            return stack2;
        }
        if(n == 0) {
            return stack1;
        }
        int[] res = new int[len];

        int i = 0, j = 0, iter = 0;
        while (i < m && j < n) {
            if(stack1[i] > stack2[j]) {
                res[iter++] = stack1[i++];
            } else if(stack1[i] < stack2[j]) {
                res[iter++] = stack2[j++];
            } else {
                int i1 = i + 1, j1 = j + 1;
                while(i1 < m && j1 < n) {
                    if(stack1[i1] > stack2[j1]) {
                        res[iter++] = stack1[i++];
                        break;
                    } else if(stack1[i1] < stack2[j1]) {
                        res[iter++] = stack2[j++];
                        break;
                    }
                    i1++;
                    j1++;
                }

                if (i1 == m) {
                    res[iter++] = stack2[j++];
                } else if (j1 == n) {
                    res[iter++] = stack1[i++];
                }
            }
        }

        if(i == m) {
            System.arraycopy(stack2, j, res, iter, n - j);
        } else {
            System.arraycopy(stack1, i, res, iter, m - i);
        }

        return res;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.maxNumber(
                new int[]{5,6,8},
                new int[]{6,4,0},
                3);
    }

}
