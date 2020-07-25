/**
 * Leetcode - parallel_courses_ii
 */
package com.leetcode.parallel_courses_ii;

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
class Solution2 implements Solution {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        // step 1. save the courses we need to take as integer
        // e.x.) if prerequisites for course 2 are courses 0 and 3 store integer value of `1001` to prerequisites[2]
        int[] prerequisites = new int[n];
        for (int[] dependency : dependencies)
            prerequisites[dependency[1] - 1] |= 1 << (dependency[0] - 1);

        // step 2. dp[courses] = what is the minimum number of days it takes to finish the course given that we have the `courses` left to take?
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n + 1); // fill with the dp array with arbitrary values not possible to exceed
        dp[0] = 0; // no courses left to take == no more semester necessary

        for (int i = 0; i < (1 << n); i++) {
            // i = courses we have taken
            int availableCourses = 0; // courses we can take in the semester given we took
            for (int course = 0; course < n; course++)
                if ((prerequisites[course] & i) == prerequisites[course])
                    // if `i` courses (the courses we already have taken) contain all prerequisites for `course`, add it to `availableCourses`
                    availableCourses |= 1 << course;
            availableCourses &= ~i; // remove the courses we have already taken
            for (int nextSemester = availableCourses; nextSemester > 0; nextSemester = (nextSemester - 1) & availableCourses) {
                // iterate throught the subsets of available courses we can take next
                // nextSemester = courses we choose to take next semester;
                if (Integer.bitCount(nextSemester) <= k) // # courses must be <= k
                    dp[i | nextSemester] = Math.min(dp[i | nextSemester], 1 + dp[i]);
            }
        }

        return dp[(1 << n) - 1]; //  since the problem assumes it is possible, I am not considering a corner case where the courses are impossible to finish
    }


}
