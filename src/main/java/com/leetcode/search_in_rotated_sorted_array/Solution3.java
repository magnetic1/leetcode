package com.leetcode.search_in_rotated_sorted_array;

public class Solution3 {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        return search(nums, low, high, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if (nums[mid] == target)
            return mid;
        if (nums[mid] > nums[low]) {
            if (nums[low] <= target && nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;

            return search(nums, low, high, target);

        } else if (nums[mid] < nums[high]) {
            if (nums[high] >= target && nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            return search(nums, low, high, target);

        } else {
            int tmp = search(nums, low, mid - 1, target);
            if (tmp >= 0) {
                return tmp;
            } else {
                return search(nums, mid + 1, high, target);
            }
        }
    }


    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.search(new int[]{4, 4, 4, 4, 4, 4, 4, 4, 1,  4}, 1));
    }
}
