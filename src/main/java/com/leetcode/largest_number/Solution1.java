/**
 * Leetcode - largest_number
 */
package com.leetcode.largest_number;

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

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (o1, o2) -> strCompare(o1, o2));

        if (strArr[nums.length - 1].equals("0")) {
            return "0";
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(strArr[i]);
        }

        return sb.toString();
    }

    static int strCompare(String o1, String o2) {
        int len = Math.min(o1.length(), o2.length());
        for (int i = 0; i < len; i++) {
            char c1 = o1.charAt(i), c2 = o2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }

        if (o1.length() == o2.length()) {
            return 0;
        } else if (o1.length() < o2.length()) {
            return strCompare(o1, o2.substring(len));
        } else {
            return strCompare(o1.substring(len), o2);
        }

    }

}
