/**
 * Leetcode - implement_strstr
 */
package com.leetcode.implement_strstr;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.ciaoshen.leetcode.helper.PropertyScanner;
import com.ciaoshen.leetcode.util.*;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (isMatch(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isMatch(String haystack, String needle, int index) {
        if (haystack.charAt(index) == needle.charAt(0)) {
            return haystack.substring(index, index + needle.length()).equals(needle);
        }
        //        for (int i = 0; i < needle.length(); i++) {
//            if (haystack.charAt(index + i) != needle.charAt(i)) {
//                return false;
//            }
//        }
        return false;
    }

    public static void main(String[] args) {


    }
}
