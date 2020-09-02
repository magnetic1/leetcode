/**
 * Leetcode - number_of_ways_to_reorder_array_to_get_same_bst
 */
package com.leetcode.number_of_ways_to_reorder_array_to_get_same_bst;

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
    static long[] fact, ifact;
    int MAX = 1000;
    long MOD = (int) 1e9 + 7;
    public static boolean calced = false;

    public void pre() {
        fact = new long[1 + MAX];
        ifact = new long[1 + MAX];
        fact[0] = ifact[0] = 1;
        for (int i = 1; i <= MAX; i++) fact[i] = (fact[i - 1] * i) % MOD;
        ifact[MAX] = pow(fact[MAX], MOD - 2);
        for (int i = MAX - 1; i >= 1; i--) ifact[i] = (ifact[i + 1] * (long) (i + 1)) % MOD;
        calced = true;
    }

    long pow(long a, long p) {
        long o = 1;
        for (; p > 0; p >>= 1) {
            if ((p & 1) == 1) o = (o * a) % MOD;
            a = (a * a) % MOD;
        }
        return o;
    }

    long nCk(int n, int k) {
        return fact[n] * (long) ifact[k] % MOD * (long) ifact[n - k] % MOD;
    }

    public int numOfWays(int[] nums) {
        if (!calced) pre();
        Node root = null;
        for (int x : nums) root = insert(root, x);
        return (int) calc(root) - 1;
    }

    long calc(Node root) {
        if (root == null) return 1;
        long ways = (calc(root.le) * calc(root.ri)) % MOD;
        ways *= nCk(sz(root.le) + sz(root.ri), sz(root.le));
        return ways % MOD;
    }

    Node insert(Node tmp, int value) {
        if (tmp == null) return new Node(value);
        if (value < tmp.val) tmp.le = insert(tmp.le, value);
        else tmp.ri = insert(tmp.ri, value);
        tmp.sz = sz(tmp.le) + sz(tmp.ri) + 1;
        return tmp;
    }

    int sz(Node node) {
        return node == null ? 0 : node.sz;
    }

    class Node {
        int val, sz;
        Node le, ri;

        public Node(int v) {
            val = v;
            sz = 1;
            le = null;
            ri = null;
        }
    }
}
