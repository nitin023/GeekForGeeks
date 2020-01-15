package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 *
 * Output:
 * Print the maximum sum of the contiguous sub-array in a separate line for each test case.
 *
 * Constraints:
 * 1 ≤ T ≤ 110
 * 1 ≤ N ≤ 106
 * -107 ≤ A[i] <= 107
 *
 * Example:
 * Input
 * 2
 * 5
 * 1 2 3 -2 5
 * 4
 * -1 -2 -3 -4
 * Output
 * 9
 * -1
 *
 * Explanation:
 * Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
 */
public class KandaneAlgorithm {

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
            getMaximuContingousSum(inputList,numElem);
            testCases--;
        }
    }

    /**
     * Problem gets solved using DP approach
     * where it breaks to choose maximum sum between the current sum coming from previous indexes
     * and current index for the sum
     * resulting into maximum sum
     * @param list
     * @param numElem
     */
    public static void getMaximuContingousSum(List<Integer> list , int numElem)
    {
        int maximumSum = list.get(0);
        int currentSum = list.get(0);
        int sum1 , sum2;
        for(int i = 1 ; i < numElem ; i++)
        {
            sum1 = list.get(i) + currentSum;
            sum2 = list.get(i);
            currentSum = Math.max(sum1,sum2);
            if(currentSum > maximumSum)
            {
                maximumSum = currentSum;
            }
        }
        System.out.println(maximumSum);
    }
}
