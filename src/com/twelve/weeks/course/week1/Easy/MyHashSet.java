package com.twelve.weeks.course.week1.Easy;

public class MyHashSet {
    LinkedList[] buckets;
    int MAX = 100000;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.buckets = new LinkedList[MAX];
    }

    public void add(int key) {
        int index = getIndexFromHashCode(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList();
        }
        LinkedList linkedList = buckets[index];
        if (linkedList.head == null) {
            linkedList.head = new Node(key);
        } else {
            boolean isKeyNotPresent = true;
            Node linkedListHead = linkedList.head;
            while (linkedListHead.next != null) {
                if (linkedListHead.key != key) {
                    linkedListHead = linkedListHead.next;
                    isKeyNotPresent = false;
                    break;
                }
            }
            if (isKeyNotPresent) {
                if (linkedListHead.key != key) {
                    linkedListHead.next = new Node(key);
                }
            }
        }
        buckets[index] = linkedList;
    }

    public void remove(int key) {

        int index = getIndexFromHashCode(key);
        if (buckets[index] == null) {
            return;
        }
        LinkedList linkedList = buckets[index];
        Node linkedListHead = linkedList.head;
        Node prev = null;
        while (linkedListHead != null) {
            if (linkedListHead.key == key) {
                if (prev != null) {
                    prev.next = linkedListHead.next;
                } else {
                    linkedListHead = linkedListHead.next;
                    linkedList.head = linkedListHead;
                }
                if (linkedList.head == null) {
                    buckets[index] = null;
                } else {
                    buckets[index] = linkedList;
                }

                return;
            }
            prev = linkedListHead;
            linkedListHead = linkedListHead.next;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int indexMappedForKey = getIndexFromHashCode(key);
        LinkedList linkedList = buckets[indexMappedForKey];
        if (linkedList == null) {
            return false;
        }

        boolean keyInsideLinkedList = false;
        Node linkedListHead = linkedList.head;
        while (linkedListHead != null) {
            if (linkedListHead.key == key) {
                keyInsideLinkedList = true;
                break;
            }
        }
        return keyInsideLinkedList;
    }

    private int getIndexFromHashCode(int key) {
        Integer hashedKey = key;
        int hashedKeyIndex = hashedKey.hashCode() % MAX;
        return hashedKeyIndex;
    }

    class LinkedList {
        Node head;
    }

    class Node {
        int key;
        Node next;

        Node(int keyToAdd) {
            this.key = keyToAdd;
        }
    }
}
