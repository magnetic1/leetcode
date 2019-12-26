/**
 * Leetcode - three_sum_closest
 */
package com.leetcode.three_sum_closest;
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
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (Math.abs(result - target) > Math.abs(sum - target)) {
                    System.out.println("ok");
                    result = sum;
                }

                if (sum < target) {
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                } else {
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                }

            }

            while (nums[i] == nums[i + 1] && i < nums.length - 2) {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));

    }

}
