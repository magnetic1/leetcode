/**
 * Leetcode - split_array_into_fibonacci_sequence
 */
package com.leetcode.split_array_into_fibonacci_sequence;
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

    public List<Integer> splitIntoFibonacci(String S) {
        int n = S.length();

        if (n <= 2) {
            return new ArrayList<>();
        }

        for(int i = 1; i <= n/2 && i < 11; i++) {
            SSS:
            for(int j = 1; j <= n/2 && j < 11; j++) {
                int iter = 0;
                List<Integer> list = new ArrayList<>();

                if(S.charAt(iter) == '0' && i != 1) {
                    break;
                }
                long s1 = Long.parseLong(S.substring(iter, iter + i));

                iter += i;
                if(S.charAt(iter) == '0' && j != 1) {
                    break;
                }
                long s2 = Long.parseLong(S.substring(iter, iter + j));

                iter += j;
                long next = s1 + s2;
                int len = ("" + next).length();

                if (s1 > Integer.MAX_VALUE || s2 > Integer.MAX_VALUE) {
                    break;
                }
                list.add((int) s1);
                list.add((int) s2);

                while(iter < n && len + iter <= n) {
                    if (next > Integer.MAX_VALUE) {
                        break SSS;
                    }
                    if (next == Long.parseLong(S.substring(iter, iter + len))) {
                        list.add((int) next);
                        s1 = s2;
                        s2 = next;
                        next = s1 + s2;
                        iter += len;
                        len = ("" + next).length();
                    } else {
                        continue SSS;
                    }
                }

                if(iter == n) {
                    return list;
                }
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.splitIntoFibonacci("0123");
    }

}
