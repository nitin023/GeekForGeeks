package GeekForGeeks.Amazon;

import LinkedList.Node;

/**
 * Swap Kth nodes from ends
 * https://practice.geeksforgeeks.org/problems/swap-kth-node-from-beginning-and-kth-node-from-end-in-a-singly-linked-list/1
 *
 * special cases of swapping two adjacent nodes
 */
public class SwapKNodesFromBeginAndEnd {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        Node head = swapkthnode(node, 4, 1);
    }

    static Node swapkthnode(Node head, int num, int K) {
        if (head == null || K > num) {
            return head;
        }

        Node p = null, q, r;
        q = head;

        int cnt = 1;

        while (cnt < K) {
            p = q;
            q = q.next;
            cnt++;
        }
        r = q.next;

        int nodeFromEnd = num - K + 1;
        cnt = 1;
        Node m, n, o;
        m = null;
        n = head;

        while (cnt < nodeFromEnd) {
            m = n;
            n = n.next;
            cnt++;
        }

        o = n != null ? n.next : null;

        if (p == null) {
            head = n;
        } else if (m == null) {
            head = q;
        } else {
            p.next = n;
        }
        q.next = o;
        if (n != r) {
            n.next = r;
        } else {
            n.next = m;
        }
        if (m != null && m != q) {
            m.next = q;
        }
        if (p != null) {
            p.next = n;
        }

        return head;
    }
}
