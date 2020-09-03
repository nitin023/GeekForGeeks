package GeekForGeeks.Amazon.LinkedList;

import LeetCode.Easy.Tree.Node;

/**
 * https://practice.geeksforgeeks.org/problems/delete-keys-in-a-linked-list/1
 * Easy Skip problem
 */
public class DeleteAllOccurrencesOfAnElement {
    public static Node deleteAllOccurrences(Node head, int x) {
        // Your code here
        if (head == null) {
            return null;
        }

        Node headIter = head, prev = null;

        while (headIter != null) {
            if (headIter.val == x) {
                //del at head
                if (prev == null) {
                    headIter = headIter.next;
                    head = head.next;
                } else {
                    prev.next = headIter.next;
                    headIter = headIter.next;
                }
            } else {
                prev = headIter;
                headIter = headIter.next;
            }
        }
        return head;
    }
}
