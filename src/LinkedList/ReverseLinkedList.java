package LinkedList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseLinkedList {

    public static void main(String[] args) throws IOException {

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
            reverseList(createLinkedList(arr,numElem));
            testCases--;
        }
    }

    public static Node createLinkedList(int []arr , int n)
    {
        Node head  = new Node(arr[0]);
        Node temp = head;
        for(int i = 1 ; i < n ;i++)
        {
            head.next = new Node(arr[i]);
            head = head.next;
        }
        head = temp;
        return head;
    }

    private static Node reverseList(Node head)
    {
        if(head == null)
        {
            return null;
        }

        Node a  = null , b = head , c = head.next ;
        while (c!=null)
        {
            b.next = a;
            a = b ;
            b = c ;
            c = c.next;
        }
        b.next = a;
        a = b ;
        head = a;
        return head;
    }
}
