/**
 * Leetcode - regular_expression_matching
 */
package com.leetcode.regular_expression_matching;
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
    public boolean isMatch(String s, String p) {
        char[] cArray = s.toCharArray();
        boolean reach[][] = new boolean[p.length() + 1][p.length() + 1];

        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                reach[i - 1][i + 1] = true;
                reach[i + 1][i - 1] = true;
                reach[i][i + 1] = true;
                reach[i][i - 1] = true;
            }
        }

        // 记录初始可能到达的状态（通过epsilon转换）
        Set<Integer> nodes = new HashSet<>();
        nodes.add(0);
        for (int i = 0; i <= p.length(); i++) {
            if (isReach(0, i, reach)) {
                nodes.add(i);
                System.out.println("start:" + i);
            }
        }
        for (int i = 0; i < cArray.length; i++) {
            // 计算txt[i+1]可能到达的所有NFA状态
            List<Integer> match = new ArrayList<>();
            // 匹配转换
            for (int v : nodes) {
                if (v < p.length()) {
                    if (p.charAt(v) == cArray[i] || p.charAt(v) == '.') {
                        match.add(v + 1);
                        System.out.println("" + (v + 1));
                    }
                }
            }

            // 通过epsilon转换更新pc
            nodes = new HashSet<>();
            for (int m : match) {
                nodes.add(m);
                for (int j = 0; j <= p.length(); j++) {
                    if (isReach(m, j, reach)) {
                        nodes.add(j);
                    }
                }
            }
        }

        for (int v : nodes) {
            if (v == p.length()) {
                return true;
            }
        }
        return false;
    }

    private boolean isReach(int i, int j, boolean[][] reach) {
        if (reach[i][j]) {
            return true;
        }
        for (int m = i + 1; m < reach.length; m++) {
            if (reach[i][m]) {
                if (isReach(m, j, reach)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isMatch("aaaaaaaaaaaaab", "a*b"));

    }

}
