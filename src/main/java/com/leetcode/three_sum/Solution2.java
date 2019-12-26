package com.leetcode.three_sum;
import java.util.*;

/**
 * Leetcode - three_sum
 *
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
@SuppressWarnings({"WeakerAccess"})
class Solution2 implements Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    sumList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]) ;
                } else if (sum < 0) {
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                } else {
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]) ;
                }
            }

            while (nums[i] == nums[i + 1] && i < nums.length - 2) {
                i++;
            }

        }

        return sumList;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.threeSum(new int[]{-4, -1, -1, 0, 1, 2}));
    }

}
