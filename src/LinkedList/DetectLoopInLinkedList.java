package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static LinkedList.ReverseLinkedList.createLinkedList;

/**
 * Given a linked list of N nodes. The task is to check if the the linked list has a loop. Linked list can contain self loop.
 *
 * Input:
 * First line of input contains number of testcases T. For each testcase, first line of input contains length of linked list and next line contains the data of linked list.
 *
 * Output:
 * For each testcase, print "True", if linked list contains loop, else print "False".
 *
 * User Task:
 * The task is to complete the function detectloop() which contains reference to the head as only argument. This function should return 1 if linked list contains loop, else return 0.
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= N <= 300
 *
 * Example:
 * Input:
 * 2
 * 3
 * 1 3 4
 * 2
 * 4
 * 1 8 3 4
 * 0
 *
 * Output:
 * True
 * False
 *
 * Explaination:
 * Testcase 1: In above test case N = 3. The linked list with nodes N = 3 is given. Then value of x=2 is given which means last node is connected with xth node of linked list. Therefore, there exists a loop.
 *
 * Testcase 2: For N = 4
 * x = 0 means then lastNode->next = NULL, then the Linked list does not contains any loop.
 */
public class DetectLoopInLinkedList {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());
            int[] arr = new int[numElem];
            st = new StringTokenizer(br.readLine());

            int i = 0;
            while (st.hasMoreElements())
            {
                arr[i++] = Integer.parseInt(st.nextToken());
            }
            Node head = createLinkedList(arr,numElem);
            System.out.println(detectLoop(head));
            testCases--;
        }
    }

    private static int detectLoop(Node head) {
        int response = 0;
        if(head == null)
        {
            return response;
        }

        Node fast = head , slow = head;
        while (fast !=null && slow !=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                response = 1;
                break;
            }
        }
        return response;
    }
}
