package LeetCode.Easy.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthElemFromEnd {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = removeNthFromEnd(listNode,1);
    }


    /**
     * This solution uses map to find the respective node
     * and use end-startIndex technique to find element from end
     * and we then using map hover to that element and remove it
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
        {
            return null;
        }

        Map<Integer, List<ListNode>> nodeIndexToPrevNodeAddressMap = new HashMap<>();
        int nodeIndex = 1;
        ListNode tmp = head , prev = null;
        while (tmp !=null)
        {
            List<ListNode> tmpNodes = new ArrayList<>();
            tmpNodes.add(prev);
            tmpNodes.add(tmp);
            nodeIndexToPrevNodeAddressMap.put(nodeIndex,tmpNodes);
            nodeIndex++;
            prev = tmp;
            tmp = tmp.next;
        }

        int nodeIndexFromBeginning = nodeIndex - n ;

        List<ListNode> nodes = nodeIndexToPrevNodeAddressMap.get(nodeIndexFromBeginning);
        prev = nodes.get(0);
        tmp = nodes.get(1);

        if(prev!=null) {
            prev.next = tmp.next;
        }
        else
        {
            head = head.next;
        }
        return head;
    }

}


