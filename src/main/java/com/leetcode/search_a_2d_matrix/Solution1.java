/**
 * Leetcode - search_a_2d_matrix
 */
package com.leetcode.search_a_2d_matrix;
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

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);

        if (row < 0) {
            return false;
        }

        return findCol(matrix[row], target);

    }

    boolean findCol(int[] arr, int target) {
        int n = arr.length;

        int low = 0, high = n - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;
        }

        return false;
    }

    int findRow(int[][] matrix, int target) {
        int m = matrix.length;

        int low = -1, high = m - 1;
        int mid = (low + high + 1) / 2;

        while (low < high) {
            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }

            mid = (low + high + 1) / 2;
        }

        return high;
    }

}
