/**
 * Leetcode - smallest_string_with_swaps
 */
package com.leetcode.smallest_string_with_swaps;

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
class Solution1 implements Solution {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = i;
            i++;
        }

        for (List<Integer> pair : pairs) {
            int a = find(p, pair.get(0));
            int b = find(p, pair.get(1));
            if (a != b) {
                p[b] = a;
            }
        }

        Map<Integer, List<Character>> charsMap = new HashMap<>();
        Map<Integer, List<Integer>> indexsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int type = find(p, i);
            List<Character> charList = charsMap.getOrDefault(type, new ArrayList<>());
            charList.add(chars[i]);
            charsMap.put(type, charList);

            List<Integer> indexList = indexsMap.getOrDefault(type, new ArrayList<>());
            indexList.add(i);
            indexsMap.put(type, indexList);
        }

        for (Map.Entry<Integer, List<Character>> entry : charsMap.entrySet()) {
            int type = entry.getKey();
            List<Character> charList = entry.getValue();
            charList.sort(Character::compareTo);

            List<Integer> indexList = indexsMap.get(type);
            for (int i = 0; i < indexList.size(); i++) {
                chars[indexList.get(i)] = charList.get(i);
            }
        }

        return new String(chars);
    }

    int find(int[] p, int i) {
        if (p[i] != i) {
            p[i] = find(p, p[i]);
        }
        return p[i];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2)));
    }
}
