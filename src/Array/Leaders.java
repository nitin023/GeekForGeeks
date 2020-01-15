package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given an array of positive integers. Your task is to find the leaders in the array.
 * Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 * The first line of each test case contains a single integer N denoting the size of array.
 * The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 *
 * Output:
 * Print all the leaders.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 0 <= Ai <= 107
 *
 * Example:
 * Input:
 * 3
 * 6
 * 16 17 4 3 5 2
 * 5
 * 1 2 3 4 0
 * 5
 * 7 4 5 7 3
 * Output:
 * 17 5 2
 * 4 0
 * 7 7 3
 *
 * Explanation:
 * Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7. Also, all the elements of right side of 7 (at index 3) are smaller than 7. And, the last element 3 is itself a leader since no elements are on its right.
 */
public class Leaders {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases>0)
        {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> inputList = new ArrayList<>();

            while (st.hasMoreElements())
            {
                inputList.add(Integer.parseInt(st.nextToken()));
            }
            getLeaders(inputList,numElem);
            testCases--;
        }
    }

    /**
     * Simple problem
     * reduces to find the solution from back side of array
     * use it to determine current leader if any other value greater than current
     * leader is found then that could become the new leader(reverse iteration)
     * @param list
     * @param numElem
     */
    private static void getLeaders(List<Integer> list,int numElem) {

        int currentLeader  = list.get(numElem-1);
        List<Integer>responseList = new ArrayList<>();
        responseList.add(currentLeader);
        for(int i = numElem - 2 ; i>=0 ; i--)
        {
            if(list.get(i) >= currentLeader)
            {
                responseList.add(list.get(i));
                currentLeader = list.get(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=responseList.size() - 1 ; i>=0;i--)
        {
            sb.append(responseList.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
