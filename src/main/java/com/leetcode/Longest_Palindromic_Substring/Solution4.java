package com.leetcode.Longest_Palindromic_Substring;

import java.util.Date;

public class Solution4 {
    int len = 0, maxLength = 0, start = 0;
    public String longestPalindrome(String s) {

        char[] arr = s.toCharArray();

        len = s.length();

        if (len <= 1) return s;

        for (int i = 0; i < len; i++) {
            i = helper(arr, i);
        }
        return s.substring(start, start + maxLength);
    }

    public int helper(char[] arr, int k) {

        int i = k - 1, j = k;
        while (j < len - 1 && arr[j] == arr[j + 1]) j++;
        int nextCenter = j++;

        while (i >= 0 && j < len && arr[i] == arr[j]) {
            i--;
            j++;
        }

        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            start = i + 1;
        }

        return nextCenter;
    }

    public static void main(String[] args) {
        String str = "dadfwfjdggwjdwdgwkwqyrqwfdeuabcdefghijklmnopqrstuvwxyzabccbazyxwvutsrqponmlkjihgfedcbawfwwsdsrfrefwefeffffdafffgffdsfffadfffdsfff3r3rwwwwfdchjkwwwdsad";
        long startTime, endTime;

        startTime = System.currentTimeMillis();    //获取开始时间
        Solution4 s4 = new Solution4();
        for (int i = 0; i < 10000; i++) {
            s4.longestPalindrome(str);
        }
        System.out.println(s4.longestPalindrome(str));
        endTime = System.currentTimeMillis();    //获取开始时间
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();    //获取开始时间
        Solution3 s3 = new Solution3();
        for (int i = 0; i < 10000; i++) {
            s3.longestPalindrome(str);
        }
        System.out.println(s3.longestPalindrome(str));
        endTime = System.currentTimeMillis();    //获取开始时间
        System.out.println(endTime - startTime);


    }
}
