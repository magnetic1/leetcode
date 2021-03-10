/**
 * Leetcode - basic_calculator
 */
package com.leetcode.basic_calculator;
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

    int i = 0;
    String str;
    public int calculate(String s) {
        str = s;
        return calculate();
    }

    public int calculate() {
        int n = str.length();
        if(i == n) {
            return 0;
        }

        int num = 0;
        Deque<Character> stack = new LinkedList<>();

        while(i < n) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                if(stack.isEmpty() || stack.pop() == '+') {
                    num += getNumber();
                    // return num;
                } else {
                    num -= getNumber();
                }
            } else if(c == '(') {
                i++;
                if(stack.isEmpty() || stack.pop() == '+') {
                    num += calculate();
                } else {
                    num -= calculate();
                }
            } else if(c == '+' || c == '-') {
                i++;
                stack.push(c);
            } else if(c == ')') {
                i++;
                return num;
            } else {
                i++;
            }
        }

        return num;
    }

    public int getNumber() {
        int n = str.length();
        if(i == n) {
            return 0;
        }
        int num = 0;
        while(i < n) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                return num;
            }
            i++;
        }
        return num;
    }

}
