package LeetCode.Recursion;

/**
 *
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */
public class SwapNodesInLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode newHead  = swapPairsIteratively(head);
    }

    public static ListNode swapPairsIteratively(ListNode head) {

        if(head == null)
        {
            return null;
        }

        else if(head.next == null)
        {
            return head;
        }

        ListNode prevNode = head , nextNode ,nextNodeNext , tempHead = null ,tempConnector = null;

        while (prevNode !=null && prevNode.next !=null)
        {
            nextNode = prevNode.next;
            nextNodeNext = nextNode.next;

            //swap prev/next node
            nextNode.next = prevNode;

            if(tempConnector !=null)
            {
                tempConnector.next = nextNode;
            }

            if(tempHead == null)
            {
                tempHead = nextNode;
            }
            prevNode.next = nextNodeNext;
            tempConnector = prevNode;
            prevNode = nextNodeNext;
        }

        head = tempHead;
        return head;
    }
}
