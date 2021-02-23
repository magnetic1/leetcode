package com.leetcode.lru_cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            swapToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.value = value;
            swapToHead(node);
        } else if(size < capacity) {
            DLinkedNode node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
        } else {
            DLinkedNode node = new DLinkedNode(key, value);
            cache.put(key, node);
            DLinkedNode next = remove(tail.prev);
            addToHead(node);
            cache.remove(next.key);
        }
    }

    void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.next.prev = node;

        node.prev = head;
        head.next = node;
    }

    DLinkedNode remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    void swapToHead(DLinkedNode node) {
        remove(node);
        addToHead(node);
    }
}



