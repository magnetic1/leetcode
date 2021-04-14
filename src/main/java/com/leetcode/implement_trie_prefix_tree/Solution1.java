/**
 * Leetcode - implement_trie_prefix_tree
 */
package com.leetcode.implement_trie_prefix_tree;

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

    static class Trie {

        static class Node {
            boolean isWord;
            Node[] children;

            Node() {
                children = new Node[26];
            }
        }

        Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Node();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node node = searchPrefix(word);
            return node != null && node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node node = searchPrefix(prefix);
            return node != null;
        }

        private Node searchPrefix(String prefix) {
            Node node = root;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                char c = prefix.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return null;
                }
                node = node.children[c - 'a'];
            }
            return node;
        }
    }

}
