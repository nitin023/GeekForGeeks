package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 *
 * Input:
 * The first line contains an integer T, depicting total number of test cases.  Then T test case follows. First line of each test case contains an integer N denoting the size of the array. Next line contains N space separated integeres denoting the elements of the array.
 *
 * Output:
 * Print the maximum difference of the indexes i and j in a separtate line.
 *
 * Constraints:
 * 1 ≤ T ≤ 1000
 * 1 ≤ N ≤ 107
 * 0 ≤ A[i] ≤ 1018
 *
 * Example:
 * Input:
 * 1
 * 9
 * 34 8 10 3 2 80 30 33 1
 *
 * Output:
 * 6
 *
 * Explanation:
 * Testcase 1:  In the given array A[1] < A[7] satisfying the required condition(A[i] <= A[j]) thus giving the maximum difference of j - i which is 6(7-1).
 */
public class MaximumIndex {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases>0)
        {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] inputArr = new int[numElem];
            int i = 0;

            while (st.hasMoreElements())
            {
                inputArr[i++] = (Integer.parseInt(st.nextToken()));
            }
            GetMaximumIndex(inputArr,numElem);
            testCases--;
        }
    }

    public static void GetMaximumIndex(int [] inputArr , int numElem)
    {
       int maxDiff = -1 ;
       int i;
       int []sortedArr = new int[numElem];
        Map<Integer,Integer> valueIndexUnSortedMap = new HashMap<>();
       for(i = 0 ; i < numElem ; i++)
       {
           sortedArr[i] = inputArr[i];
           valueIndexUnSortedMap.put(inputArr[i],i);
       }
        Arrays.sort(sortedArr);
       Map<Integer,Integer> valueIndexSortedMap = new HashMap<>();

       for(i = 0 ; i < sortedArr.length ; i++)
       {
           valueIndexSortedMap.put(sortedArr[i],i);
       }

       maxDiff = -1;
       for(i = 0 ; i< numElem ; i++)
       {
           int iIndexInSortedOrder = valueIndexSortedMap.get(inputArr[i]);
           for(int j = iIndexInSortedOrder + 1 ; j<numElem ; j++)
           {
              int elem = sortedArr[j];
              int k = valueIndexUnSortedMap.get(elem);
              if(k - i > 0 && maxDiff < k-i)
              {
                  maxDiff = k-i;
              }
              if(maxDiff == (numElem-i-2))
              {
                  break;
              }
           }
           if(maxDiff == (numElem-i-2))
           {
               break;
           }
       }
        System.out.println(maxDiff);
    }
}
