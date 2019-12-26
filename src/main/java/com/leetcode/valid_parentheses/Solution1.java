/**
 * Leetcode - valid_parentheses
 */
package com.leetcode.valid_parentheses;
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
@SuppressWarnings({"WeakerAccess"})
class Solution1 implements Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty()) {
                        return false;
                    }
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty()) {
                        return false;
                    }
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
            }

        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isValid("}"));
    }


}
