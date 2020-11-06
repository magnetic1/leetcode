/**
 * Leetcode - word_ladder
 */
package com.leetcode.word_ladder;

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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        int[] distances = new int[wordList.size()];
        // Arrays.fill(distances, wordList.size());

        int[] indexs = new int[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            indexs[i] = i;
        }
        int gap = wordList.size() - 1;
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (s.equals(endWord)) {
                distances[i] = 0;
                int temp = indexs[i];
                indexs[i] = indexs[gap];
                indexs[gap] = temp;
                break;
            }
        }


        int lastGap = gap + 1;
        while (gap > 0 && lastGap != gap) {
            lastGap = gap;

            for (int i = 0; i < gap; i++) {
                int min_distance = Integer.MAX_VALUE;
                for (int j = lastGap; j < wordList.size(); j++) {
                    String s1 = wordList.get(indexs[i]);
                    String s2 = wordList.get(indexs[j]);
                    if (1 == dist(s1, s2)) {
                        min_distance = Math.min(min_distance, distances[indexs[j]] + 1);
                    }
                }
                if (min_distance != Integer.MAX_VALUE) {
                    distances[indexs[i]] = min_distance;
                    int temp = indexs[i];
                    indexs[i] = indexs[gap - 1];
                    indexs[gap - 1] = temp;
                    gap--;
                    i--;
                }
            }
        }
        int min_distance = Integer.MAX_VALUE;
        for (int i = gap; i < wordList.size(); i++) {
            String s2 = wordList.get(indexs[i]);
            if (1 == dist(beginWord, s2) ) {
                min_distance = Math.min(min_distance, distances[indexs[i]] + 1);
            }
        }

        if (min_distance != Integer.MAX_VALUE) {
            return min_distance + 1;
        }
        return 0;
    }

    int dist(String str1, String str2) {
        int num = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                num++;
                if (num > 1) {
                    return 2;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
//        String beginWord = "hot";
//        String endWord = "dog";
//        List<String> list = new ArrayList<>();
//        list.add("hot");
//        list.add("dog");
//        list.add("dot");
        String beginWord = "hog";
        String endWord = "cog";
        List<String> list = new ArrayList<>();
        list.add("cog");

        Solution1 solution = new Solution1();
        solution.ladderLength(beginWord, endWord, list);
        System.out.println(solution.dist("hog", "cog"));
    }
}
