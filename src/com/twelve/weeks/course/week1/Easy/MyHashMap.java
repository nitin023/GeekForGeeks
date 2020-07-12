package com.twelve.weeks.course.week1.Easy;

public class MyHashMap {

    LinkedList[] buckets;
    int MAX_SIZE = 10000;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        buckets = new LinkedList[MAX_SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int indexPos = getIndexPositionUsingHashCode(key);
        LinkedList linkedList = buckets[indexPos];
        if (linkedList == null) {
            linkedList = new LinkedList();
            Node node = new Node(key, value);
            linkedList.head = node;
            buckets[indexPos] = linkedList;
        } else {
            Node headPtr = linkedList.head;
            Node prevNode = null;
            while (headPtr != null) {
                if (headPtr.key == key) {
                    headPtr.value = value;
                    return;
                }
                prevNode = headPtr;
                headPtr = headPtr.next;
            }

            Node node = new Node(key, value);
            prevNode.next = node;
            buckets[indexPos] = linkedList;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = getIndexPositionUsingHashCode(key);
        LinkedList linkedList = buckets[index];
        if (linkedList == null) {
            return -1;
        }

        Node headPtr = linkedList.head;
        while (headPtr != null) {
            if (headPtr.key == key) {
                return headPtr.value;
            }
            headPtr = headPtr.next;
        }

        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = getIndexPositionUsingHashCode(key);


        LinkedList linkedList = buckets[index];
        if (linkedList == null) {
            return;
        }

        Node headPtr = linkedList.head;
        Node prev = null;
        while (headPtr != null) {
            if (headPtr.key == key) {
                if (prev == null) {
                    headPtr = headPtr.next;
                } else {
                    prev.next = headPtr.next;
                    headPtr.next = null;
                }
                break;
            }
            prev = headPtr;
            headPtr = headPtr.next;
        }
        linkedList.head = headPtr;
        buckets[index] = linkedList.head == null ? null : linkedList;
    }

    public int getIndexPositionUsingHashCode(Integer key) {
        return key.hashCode() % MAX_SIZE;
    }

    class LinkedList {
        Node head;
    }

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */