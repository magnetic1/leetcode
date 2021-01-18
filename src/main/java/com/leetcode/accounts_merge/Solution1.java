/**
 * Leetcode - accounts_merge
 */
package com.leetcode.accounts_merge;

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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToIndex = new HashMap<>();
        int n = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, n++);
                }
            }
        }

        UnionFind uf = new UnionFind(n);

        for (List<String> account : accounts) {
            String email1 = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String email2 = account.get(i);
                uf.union(emailToIndex.get(email1), emailToIndex.get(email2));
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int i = uf.find(emailToIndex.get(email));
            List<String> emails = indexToEmails.getOrDefault(i, new ArrayList<>());
            emails.add(email);
            indexToEmails.put(i, emails);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : indexToEmails.entrySet()) {
            int i = entry.getKey();
            List<String> emails = entry.getValue();
            emails.sort(String::compareTo);
            String name = emailToName.get(emails.get(0));
            emails.add(0, name);
            ans.add(emails);
        }

        return ans;
    }

}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
