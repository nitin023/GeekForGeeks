package LinkedList;

/**
 * You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head node is not given.
 *
 * Note: No head reference is given to you.
 *
 * Input Format:
 * First line of input contains number of testcases T. For each testcase, first line of input contains length of linked list and next line contains the data of the linked list. The last line contains the node to be deleted.
 *
 * Output Format:
 * For each testcase, in a newline, print the linked list after deleting the given node.
 *
 * Your Task:
 * This is a function problem. You only need to complete the function deleteNode that takes reference to the node that needs to be deleted. The printing is done automatically by the driver code.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 103
 *
 * Example:
 * Input:
 * 2
 * 2
 * 1 2
 * 1
 * 4
 * 10 20 4 30
 * 20
 *
 * Output:
 * 2
 * 10 4 30
 *
 * Explanation:
 * Testcase 1: After deleting 20 from the linked list, we have remaining nodes as 10, 4 and 30
 */
public class DeleteHeadWithoutPtr {

    /**
     * Approach to solve problem
     * 1) Do make use of current node and its node.next
     * 2) dont delete current node but you can update node data to next node data
     * 3) and delete next node
     * @param node
     */
    public void deleteNode(Node node)
    {
        if(node == null || node.next==null)
        {
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
}



