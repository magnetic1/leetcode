/**
 * Leetcode - group_anagrams
 */
package com.leetcode.group_anagrams;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (map.containsKey(key)) {
                List<String> stringList = map.get(key);
                stringList.add(str);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(key, stringList);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }

}
