package LeetCode.Recursion;

/**
 * Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode newHead = swapPairsRecursively(head, null, null);
        System.out.println(1);
    }

    public static ListNode swapPairsIteratively(ListNode head) {

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode prevNode = head, nextNode, nextNodeNext, tempHead = null, tempConnector = null;

        while (prevNode != null && prevNode.next != null) {
            nextNode = prevNode.next;
            nextNodeNext = nextNode.next;

            //swap prev/next node
            nextNode.next = prevNode;

            if (tempConnector != null) {
                tempConnector.next = nextNode;
            }

            if (tempHead == null) {
                tempHead = nextNode;
            }
            prevNode.next = nextNodeNext;
            tempConnector = prevNode;
            prevNode = nextNodeNext;
        }

        head = tempHead;
        return head;
    }

    /**
     * Just converted the iterative loop to recursion call and we are done with recursive soln
     *
     * @param prevNode
     * @param tempHead
     * @param tempConnector
     * @return
     */
    public static ListNode swapPairsRecursively(ListNode prevNode, ListNode tempHead, ListNode tempConnector) {

        ListNode nextNode, nextNodeNext;

        if (prevNode == null || prevNode.next == null) {
            return null;
        }
        nextNode = prevNode.next;

        nextNodeNext = nextNode.next;

        nextNode.next = prevNode;
        if (tempConnector != null) {
            tempConnector.next = nextNode;
        }

        if (tempHead == null) {
            tempHead = nextNode;
        }

        prevNode.next = nextNodeNext;
        tempConnector = prevNode;
        prevNode = nextNodeNext;

        swapPairsRecursively(prevNode, tempHead, tempConnector);
        return tempHead;
    }
}
