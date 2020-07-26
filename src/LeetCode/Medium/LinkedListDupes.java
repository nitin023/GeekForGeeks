package LeetCode.Medium;

import LinkedList.Node;

/**
 * 82. Remove Duplicates from Sorted List II
 */
public class LinkedListDupes {
    public Node deleteDuplicates(Node head) {

        if (head == null) {
            return head;
        }

        Node p = head, q, prevToP = null;

        while (p != null) {
            int dataToCheck = p.data;
            q = p.next;
            int cnt = 1;
            while (q != null && q.data == dataToCheck) {
                q = q.next;
                cnt++;
            }
            if (cnt > 1) {
                if (prevToP != null) {
                    prevToP.next = q;
                    p = q;
                } else {
                    p = q;
                    head = p;
                }
            } else {
                prevToP = p;
                p = p.next;
            }
        }

        return head;
    }
}
