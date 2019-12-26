package com.leetcode.letter_combinations_of_a_phone_number;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Leetcode - letter_combinations_of_a_phone_number
 *
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */

@SuppressWarnings("WeakerAccess")
class Solution1 implements Solution {
    private char[][] array = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - 50;

            List<String> newList = new ArrayList<>();

            if (index < 0 || index > 7) {
                continue;
            }

            if (i == 0) {
                for (char c : array[index]) {
                    stringList.add(new String(new char[]{c}));
                }
                continue;
            }

            for (char c : array[index]) {
                List<String> tempList = stringList.stream()
                        .map(str -> str + c)
                        .collect(Collectors.toList());

                newList.addAll(tempList);
            }

            stringList = newList;
        }

        return stringList;
    }

    public static void main(String[] args) {
//        System.out.println('0' - 48);
        Solution1 solution = new Solution1();
        System.out.println(solution.letterCombinations("23"));
    }
}
