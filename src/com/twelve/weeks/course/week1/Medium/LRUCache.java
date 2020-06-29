package com.twelve.weeks.course.week1.Medium;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> node_map;
    int node_capacity;

    public LRUCache(int capacity) {
        node_capacity = capacity;
        node_map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = node_map.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = node_map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
            node_map.put(key, node);
        } else {
            if (node_map.size() == node_capacity) {
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new Node();
            node.key = key;
            node.val = value;
            node_map.put(key, node);
            add(node);
        }
    }

    public void add(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void remove(Node node) {
        Node nodeNext = node.next;
        Node nodePrev = node.prev;

        node.prev.next = nodeNext;
        node.next.prev = nodePrev;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */