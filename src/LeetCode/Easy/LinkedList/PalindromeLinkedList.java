package LeetCode.Easy.LinkedList;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-129);
        listNode.next = new ListNode(-129);

        System.out.println(isPalindrome(listNode));

    }

    public static boolean isPalindrome(ListNode head) {

        ListNode headPtr = head;
        StringBuilder fwdString = new StringBuilder("");
        StringBuilder revString = new StringBuilder("");

        List<Integer> elems = new ArrayList<>();
        while(headPtr!=null)
        {
            fwdString.append(headPtr.val);
            elems.add(headPtr.val);
            headPtr = headPtr.next;
        }

        String str1 = fwdString.toString();
        for(int i = elems.size() -1 ; i>=0 ; i--)
        {
            revString.append(elems.get(i));
        }
        String str2 = revString.toString();

        return str1.equals(str2);
    }
}
