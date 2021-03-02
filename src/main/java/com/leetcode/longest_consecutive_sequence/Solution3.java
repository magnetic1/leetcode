package com.leetcode.longest_consecutive_sequence;

import java.util.Arrays;

public class Solution3 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int max = 0, cur = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1) {
                cur++;
            } else if(nums[i] != nums[i - 1]) {
                max = Math.max(max, cur);
                cur = 1;
            }
        }
        max = Math.max(max, cur);

        return max;
    }
}
