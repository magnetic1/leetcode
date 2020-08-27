/**
 * Leetcode - replace_words
 */
package com.leetcode.replace_words;

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

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");

        Node root = new Node(' ', false);
        for (String d : dictionary) {
            char[] chars = d.toCharArray();
            root.insert(chars, 0);
        }

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            char[] chars = w.toCharArray();
            int l = root.find(chars, 0);
            if (l > 0) {
                words[i] = new String(chars, 0, l);
            }
        }

        StringBuilder s = new StringBuilder();
        for (String w : words) {
            s.append(w).append(' ');
        }
        return s.toString().substring(0, s.length() - 1);
    }

    static class Node {
        char c;
        boolean isWord;
        List<Node> nextNodes;

        Node(char c, boolean isWord) {
            this.c = c;
            this.isWord = isWord;
            nextNodes = new ArrayList<>();
        }

        void insert(char[] chars, int i) {
            if (chars.length == i) {
                isWord = true;
                return;
            }

            for (Node nextNode : nextNodes) {
                if (nextNode.c == chars[i]) {
                    nextNode.insert(chars, i + 1);
                    return;
                }
            }
            Node node = new Node(chars[i], false);
            nextNodes.add(node);
            node.insert(chars, i + 1);
        }

        int find(char[] chars, int i) {
            if (isWord) {
                return i;
            } else if (chars.length == i) {
                return -1;
            } else {
                for (Node nextNode : nextNodes) {
                    if (nextNode.c == chars[i]) {
                        return nextNode.find(chars, i + 1);
                    }
                }
                return -1;
            }
        }

    }

}
