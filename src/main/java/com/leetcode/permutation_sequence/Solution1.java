/**
 * Leetcode - permutation_sequence
 */
package com.leetcode.permutation_sequence;

import java.util.*;

import com.ciaoshen.leetcode.util.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

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

    public String getPermutation(int n, int k) {
        int[] m = new int[n];
        boolean[] marked = new boolean[n];
        k = k - 1;

        int value = 1;
        for (int i = 0; i < n; i++) {
            m[i] = value;
            value = value * (i + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int selected = k / m[i];
            int iter = 0;
            int index = 0;
            while (iter <= selected) {
                if (!marked[index]) {
                    iter++;
                }
                index++;
            }
            marked[index - 1] = true;
            stringBuilder.append(index);

            k = k % m[i];
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.getPermutation(3, 3));
    }

}
