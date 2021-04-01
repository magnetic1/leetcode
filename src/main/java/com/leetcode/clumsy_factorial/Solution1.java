/**
 * Leetcode - clumsy_factorial
 */
package com.leetcode.clumsy_factorial;
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

    public int clumsy(int N) {
        if (N <= 1) {
            return N;
        }
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Integer> flagStack = new LinkedList<>();
        numStack.push(N);
        run(numStack, flagStack, N - 1, 0);

        while (!flagStack.isEmpty()) {
            int x = numStack.removeLast();
            int y = numStack.removeLast();
            int flag = flagStack.removeLast();

            numStack.addLast(calculate(x, y, flag));
        }

        return numStack.pop();
    }

    void run(Deque<Integer> numStack, Deque<Integer> flagStack, int n, int flag) {
        if (flag <= 1) {
            int num = calculate(numStack.pop(), n, flag);
            numStack.push(num);
        } else {
            numStack.push(n);
            flagStack.push(flag);
        }

        if (n == 1) {
            return;
        }
        run(numStack, flagStack, n - 1, (flag + 1) % 4);
    }

    int calculate(int x, int y, int flag) {
        if (flag == 0) {
            return x * y;
        } else if (flag == 1) {
            return x / y;
        } else if (flag == 2) {
            return x + y;
        } else {
            return x - y;
        }
    }

}
