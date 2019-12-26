package com.leetcode.palindrome_number;

public class Solution3 {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int reversenum = 0;
        while (x > reversenum) {
            reversenum = reversenum * 10 + x % 10;
            x = x / 10;
        }
        if (x == reversenum || x == reversenum / 10) {
            return true;
        } else {
            return false;
        }
    }
}
