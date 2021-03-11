/**
 * Leetcode - basic_calculator_ii
 */
package com.leetcode.basic_calculator_ii;
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
    String s;
    public int calculate(String s) {
        if(s == null) {
            return 0;
        }
        this.s = s;
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> charStack = new LinkedList<>();

        int n = s.length();
        boolean calculateNow = false;
        while(i < n) {
            char c = s.charAt(i);
            if(c == '+' || c == '-') {
                charStack.push(c);
                i++;
            } else if(c == '*') {
                i++;
                numStack.push(numStack.pop() * getNumber());
            } else if(c == '/') {
                i++;
                numStack.push(numStack.pop() / getNumber());
            } else if(c == ' ') {
                i++;
            } else {
                numStack.push(getNumber());
            }
        }

        while(!charStack.isEmpty()) {
            if(charStack.removeLast() == '+') {
                numStack.addLast(numStack.removeLast() + numStack.removeLast());
            } else {
                int x = numStack.removeLast(), y = numStack.removeLast();
                numStack.addLast(x - y);
            }
        }
        return numStack.pop();
    }

    int getNumber() {
        int num = 0, n = s.length();
        while(i < n) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                return num;
            }
            i++;
        }
        return num;
    }

}
