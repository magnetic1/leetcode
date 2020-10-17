/**
 * Leetcode - top_k_frequent_words
 */
package com.leetcode.top_k_frequent_words;
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

    Map<String, Integer> count = new HashMap<>();
        for(String word: words) {
        count.put(word, count.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) ->
            count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2)
    );

        for (String word: count.keySet()) {
        heap.offer(word);
        if (heap.size() > k) heap.poll();
    }

    List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;

}
