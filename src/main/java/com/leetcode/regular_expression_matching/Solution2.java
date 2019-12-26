/**
 * Leetcode - regular_expression_matching
 */
package com.leetcode.regular_expression_matching;
//import java.util.*;
import com.ciaoshen.leetcode.util.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
@SuppressWarnings("WeakerAccess,unused")
class Solution2 implements Solution {
    public boolean isMatch(String s, String p) {
        NFA nfa = new NFA(p);
        return nfa.recognizes(s);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));
    }

    class NFA {
        private char[] re;      // 匹配转换
        private Digraph G;      // epsilon转换
        private int M;          // 状态数量

        // 将所有epsilon转换(空转换)加入到有向图G中
        NFA(String regexp) {
            re = regexp.toCharArray();
            M = re.length;
            G = new Digraph(M + 1);

            // 利用一个栈构造epsilon转换构成的有向图
            Stack<Integer> ops = new Stack<>();
            for (int i = 0; i < M; i++) {
                int lp = i;
                if (re[i] == '(' || re[i] == '|') {
                    ops.push(i);
                } else if (re[i] == ')') {
                    int or = ops.pop();
                    if (re[or] == '|') {
                        lp = ops.pop();
                        G.addEdge(lp, or + 1);
                        G.addEdge(or, i);
                    } else {
                        lp = or;
                    }
                }

                if (i < M - 1 && re[i + 1] == '*') {
                    G.addEdge(lp, i + 1);
                    G.addEdge(i + 1, lp);
                }

                if (re[i] == '(' || re[i] == '*' || re[i] == ')') {
                    G.addEdge(i, i + 1);
                }
            }
        }


        boolean recognizes(String txt) {
            // 记录初始可能到达的状态（通过epsilon转换）
            DirectedDFS dfs = new DirectedDFS(G, 0);
            Bag<Integer> pc = getAccessStatus(dfs);

            for (int i = 0; i < txt.length(); i++) {
                // 计算txt[i+1]可能到达的所有NFA状态
                Bag<Integer> match = new Bag<>();
                // 匹配转换
                for (int v : pc) {
                    if (v < M) {
                        if (re[v] == txt.charAt(i) || re[v] == '.') {
                            match.add(v + 1);
                        }
                    }
                }
                // 通过epsilon转换更新pc
                dfs = new DirectedDFS(G, match);
                pc = getAccessStatus(dfs);
            }

            for (int v : pc) {
                if (v == M) {
                    return true;
                }
            }
            return false;
        }

        private Bag<Integer> getAccessStatus(DirectedDFS dfs) {
            Bag<Integer> pc = new Bag<>();
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) {
                    pc.add(v);
                }
            }
            return pc;
        }

        public boolean findin(String txt) {
            DirectedDFS dfs = new DirectedDFS(G, 0);
            Bag<Integer> pc = getAccessStatus(dfs);

            for (int i = 0; i < txt.length(); i++) {
                // 计算txt[i+1]可能到达的所有NFA状态
                Bag<Integer> match = new Bag<>();
                // 匹配转换
                for (int v : pc) {
                    if (v < M) {
                        if (re[v] == txt.charAt(i) || re[v] == '.') {
                            match.add(v + 1);
                        }
                    }
                }
                // 通过epsilon转换更新pc
                pc = new Bag<>();
                dfs = new DirectedDFS(G, match);
                for (int v = 0; v < G.V(); v++) {
                    if (dfs.marked(v)) {
                        pc.add(v);
                    }
                }
                // 是否找到匹配
                for (int v : pc) {
                    if (v == M) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class DirectedDFS {
        private boolean[] marked;
        private int count;

        public DirectedDFS(Digraph G, int s) {
            this.marked = new boolean[G.V()];
            this.validateVertex(s);
            this.dfs(G, s);
        }

        public DirectedDFS(Digraph G, Iterable<Integer> sources) {
            this.marked = new boolean[G.V()];
            this.validateVertices(sources);

            for (int v : sources) {
                if (!this.marked[v]) {
                    this.dfs(G, v);
                }
            }

        }

        private void dfs(Digraph G, int v) {
            ++this.count;
            this.marked[v] = true;

            for (int w : G.adj(v)) {
                if (!this.marked[w]) {
                    this.dfs(G, w);
                }
            }

        }

        public boolean marked(int v) {
            this.validateVertex(v);
            return this.marked[v];
        }

        public int count() {
            return this.count;
        }

        private void validateVertex(int v) {
            int V = this.marked.length;
            if (v < 0 || v >= V) {
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
            }
        }

        private void validateVertices(Iterable<Integer> vertices) {
            if (vertices == null) {
                throw new IllegalArgumentException("argument is null");
            } else {
                int V = this.marked.length;
                Iterator i$ = vertices.iterator();

                int v;
                do {
                    if (!i$.hasNext()) {
                        return;
                    }

                    v = (Integer)i$.next();
                } while(v >= 0 && v < V);

                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
            }
        }
    }

    class Bag<Item> implements Iterable<Item> {
        private Node<Item> first = null;
        private int n = 0;

        public Bag() {
        }

        public boolean isEmpty() {
            return this.first == null;
        }

        public int size() {
            return this.n;
        }

        public void add(Item item) {
            Node<Item> oldfirst = this.first;
            this.first = new Node();
            this.first.item = item;
            this.first.next = oldfirst;
            ++this.n;
        }

        public Iterator<Item> iterator() {
            return new Bag.ListIterator(this.first);
        }


        private class ListIterator<Item> implements Iterator<Item> {
            private Node<Item> current;

            public ListIterator(Node<Item> first) {
                this.current = first;
            }

            public boolean hasNext() {
                return this.current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    Item item = this.current.item;
                    this.current = this.current.next;
                    return item;
                }
            }
        }

        class Node<Item> {
            private Item item;
            private Node<Item> next;

            private Node() {
            }
        }
    }

    class Digraph {
        private final String NEWLINE = System.getProperty("line.separator");
        private final int V;
        private int E;
        private Bag<Integer>[] adj;
        private int[] indegree;

        public Digraph(int V) {
            if (V < 0) {
                throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
            } else {
                this.V = V;
                this.E = 0;
                this.indegree = new int[V];
                this.adj = (Bag[])(new Bag[V]);

                for(int v = 0; v < V; ++v) {
                    this.adj[v] = new Bag();
                }

            }
        }

        public Digraph(Digraph G) {
            this(G.V());
            this.E = G.E();

            int v;
            for(v = 0; v < this.V; ++v) {
                this.indegree[v] = G.indegree(v);
            }

            for(v = 0; v < G.V(); ++v) {
                Stack<Integer> reverse = new Stack<>();

                for (int w : reverse) {
                    reverse.push(w);
                }


                for (int w : reverse) {
                    this.adj[v].add(w);
                }
            }

        }

        public int V() {
            return this.V;
        }

        public int E() {
            return this.E;
        }

        private void validateVertex(int v) {
            if (v < 0 || v >= this.V) {
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (this.V - 1));
            }
        }

        public void addEdge(int v, int w) {
            this.validateVertex(v);
            this.validateVertex(w);
            this.adj[v].add(w);
            ++this.indegree[w];
            ++this.E;
        }

        public Iterable<Integer> adj(int v) {
            this.validateVertex(v);
            return this.adj[v];
        }

        public int outdegree(int v) {
            this.validateVertex(v);
            return this.adj[v].size();
        }

        public int indegree(int v) {
            this.validateVertex(v);
            return this.indegree[v];
        }

        public Digraph reverse() {
            Digraph reverse = new Digraph(this.V);

            for(int v = 0; v < this.V; ++v) {

                for (int w : this.adj(v)) {
                    reverse.addEdge(w, v);
                }
            }

            return reverse;
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(this.V).append(" vertices, ").append(this.E).append(" edges ").append(NEWLINE);

            for(int v = 0; v < this.V; ++v) {
                s.append(String.format("%d: ", v));

                for (int w : this.adj[v]) {
                    s.append(String.format("%d ", w));
                }

                s.append(NEWLINE);
            }

            return s.toString();
        }
    }
}

