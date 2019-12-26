package com.leetcode.four_sum;

import java.util.*;

/**
 * Leetcode - four_sum
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
@SuppressWarnings({"WeakerAccess"})
class Solution1 implements Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if( j > i+1 && nums[j] == nums[j-1])
                    continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        sumList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right) {
                            left++;
                            if (nums[left] != nums[left - 1]) {
                                break;
                            }
                        }

                        while (left < right) {
                            right--;
                            if (nums[right] != nums[right + 1]) {
                                break;
                            }
                        }
                    } else if (sum < target) {
                        while (left < right) {
                            left++;
                            if (nums[left] != nums[left - 1]) {
                                break;
                            }
                        }
                    } else {
                        while (left < right) {
                            right--;
                            if (nums[right] != nums[right + 1]) {
                                break;
                            }
                        }
                    }

                }
            }

        }

        return sumList;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 3).toString());
    }

}
