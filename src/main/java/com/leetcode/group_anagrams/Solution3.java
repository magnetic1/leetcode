package com.leetcode.group_anagrams;

public class Solution3 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            return 1 / myPow(x, Integer.MAX_VALUE) / x;
        }

//        double[] doubles = new double[100];
//        doubles[0] = x;
        double res = 1;
        int v = Math.abs(n);

        while (v != 0) {
            if ((v & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            v >>= 1;
        }


        if (n > 0) {
            return res;
        } else {
            return 1 / res;
        }
    }

    public static void main(String[] args) {
//        System.out.println(4 << 1);
        Solution3 solution = new Solution3();
        System.out.println(solution.myPow(2.00000, 10));

    }
}
