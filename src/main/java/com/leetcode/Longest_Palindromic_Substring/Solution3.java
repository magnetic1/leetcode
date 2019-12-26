package com.leetcode.Longest_Palindromic_Substring;

public class Solution3 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int length = s.length();
        boolean[][] P = new boolean[length][length];
        P[length - 1][length - 1] = true;

        int start = 0, end = 0;

        for (int i = 0; i < length - 1; i++) {
            P[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                P[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }


        for (int i = 1; i < length - 1; i++) {
            int m, n;
            m = i - 1; n = i + 1;
            while (m >= 0 && n < length) {
                if (P[m + 1][n - 1] && s.charAt(m) == s.charAt(n)) {
                    P[m][n] = true;
                    if (n - m > end - start) {
                        start = m;
                        end = n;
                    }
                    m--;
                    n++;
                } else {
                    break;
                }
            }

            m = i - 1; n = i + 2;
            while (m >= 0 && n < length) {
                if (P[m + 1][n - 1] && s.charAt(m) == s.charAt(n)) {
                    P[m][n] = true;
                    if (n - m > end - start) {
                        start = m;
                        end = n;
                    }
                    m--;
                    n++;
                } else {
                    break;
                }
            }

        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.longestPalindrome("abccbc"));
    }
}
