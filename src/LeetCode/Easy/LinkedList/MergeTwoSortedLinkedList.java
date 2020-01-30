package LeetCode.Easy.LinkedList;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(8);


       ListNode mergedList =  mergeTwoLists(l1,l1);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = null , tmpNode = null;
        if(l1==null && l2==null)
        {
            return null;
        }
        else if(l1 == null)
        {
            return l2;
        }
        else if(l2 == null)
        {
            return l1;
        }

        while (l1!=null && l2!=null)
        {
            if(l1.val <= l2.val)
            {
                if(mergedList == null)
                {
                    mergedList = new ListNode(l1.val);
                    tmpNode = mergedList;
                }
                else {
                    mergedList.next = new ListNode(l1.val);
                    mergedList = mergedList.next;
                }
                l1 = l1.next;
            }
            else
            {
                if(mergedList == null)
                {
                    mergedList = new ListNode(l2.val);
                    tmpNode = mergedList;
                }
                else {
                    mergedList.next = new ListNode(l2.val);
                    mergedList = mergedList.next;
                }
                l2 = l2.next;
            }
        }

        while (l1!=null)
        {
            mergedList.next = new ListNode(l1.val);
            l1 = l1.next;
            mergedList = mergedList.next;
        }

        while (l2!=null)
        {
            mergedList.next = new ListNode(l2.val);
            l2 = l2.next;
            mergedList = mergedList.next;
        }
        mergedList = tmpNode;
        return mergedList;
    }
}
