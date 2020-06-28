package com.twelve.weeks.course.week1.Medium;

/**
 * 707. Design Linked List
 * Medium
 * <p>
 * Design your implementation of the linked list.
 * You can choose to use the singly linked list or the doubly linked list.
 * A node in a singly linked list should have two attributes: val and next.
 * val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
 * If index equals to the length of linked list, the node will be appended to the end of linked list.
 * If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * <p>
 * Example:
 * <p>
 * Input:
 * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
 * [[],[1],[3],[1,2],[1],[1],[1]]
 * Output:
 * [null,null,null,null,2,null,3]
 * <p>
 * Explanation:
 * MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 */

public class MyLinkedList {

    int val;
    MyLinkedList head, next, tail;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        next = null;
        head = null;
        tail = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }


        MyLinkedList currentPtr = head;
        for (int i = 0; i <= index && currentPtr != null; i++) {
            if (i == index) {
                return currentPtr.val;
            }
            currentPtr = currentPtr.next;
        }
        return -1;

    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        newNode.next = head;
        head = newNode;
        size++;
        if (size == 1) {
            tail = head;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        if (head == null) {
            head = tail;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else {
            if (index == size) {
                addAtTail(val);
            } else if (index == 0) {
                addAtHead(val);
            } else {
                MyLinkedList currentPtr = head;
                MyLinkedList prevNode = null;
                for (int i = 0; i <= index; i++) {
                    if (i == index) {
                        //insert and return
                        MyLinkedList node = new MyLinkedList();
                        node.val = val;
                        node.next = currentPtr;
                        if (prevNode != null) {
                            prevNode.next = node;
                        }
                        size++;
                        if (size == 1) {
                            head = tail = node;
                        }
                        break;
                    }
                    prevNode = currentPtr;
                    currentPtr = currentPtr.next;
                }

            }
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > -1 && index < size) {
            MyLinkedList currentPtr = head;
            MyLinkedList prevNode = null;
            for (int i = 0; i <= index && currentPtr != null; i++) {
                if (i == index) {
                    if (prevNode != null) {
                        prevNode.next = currentPtr.next;
                        if (index == size - 1) {
                            tail = prevNode;
                        }
                    } else {
                        head = head.next;
                    }
                    size--;
                    return;
                }
                prevNode = currentPtr;
                currentPtr = currentPtr.next;

            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */