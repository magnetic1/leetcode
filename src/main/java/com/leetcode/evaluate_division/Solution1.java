/**
 * Leetcode - evaluate_division
 */
package com.leetcode.evaluate_division;
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

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int n = values.length;

        for(int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            double value = values[i];

            Map<String, Double> m1 = map.getOrDefault(s1, new HashMap<>());
            m1.put(s2, value);
            map.put(s1, m1);

            Map<String, Double> m2 = map.getOrDefault(s2, new HashMap<>());
            m2.put(s1, 1 / value);
            map.put(s2, m2);
        }

        int len = queries.size();
        double[] ans = new double[len];

        for(int i = 0; i < len; i++) {
            List<String> query = queries.get(i);
            String s1 = query.get(0);
            String s2 = query.get(1);

            Map<String, Integer> contains = new HashMap<>();
            double r = search(map, contains, s1, s2);

            ans[i] = r;
        }

        return ans;
    }

    double search(Map<String, Map<String, Double>> map, Map<String, Integer> contains, String s1, String s2) {
        if(!map.containsKey(s1)) {
            return -1;
        }

        Map<String, Double> m = map.get(s1);
        contains.put(s1, 0);
        for(Map.Entry<String, Double> entry : m.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            if(key.equals(s2)) {
                return value;
            } else if(!contains.containsKey(key)) {
                double r = search(map, contains, key, s2);
                if(r != -1) {
                    return value * r;
                }
            }
        }
        contains.remove(s1);
        return -1;
    }

}
