package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
 *
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.
 *
 * Output:
 * For each testcase, print the sorted array.
 *
 * Constraints:
 * 1 <= T <= 500
 * 1 <= N <= 106
 * 0 <= Ai <= 2
 *
 * Example:
 * Input :
 * 2
 * 5
 * 0 2 1 2 0
 * 3
 * 0 1 0
 *
 * Output:
 * 0 0 1 2 2
 * 0 0 1
 */
public class SortArrayZeroOneTwo {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());
            int[] arr = new int[numElem];
            st = new StringTokenizer(br.readLine());
            int i = 0;
            while (st.hasMoreElements()) {
                arr[i++] = Integer.parseInt(st.nextToken());
            }
            sortAllZerosOnesTwos(arr, numElem);
            testCases--;
        }
    }

    public static void sortAllZerosOnesTwos(int[] arr, int numElem) {
        StringBuilder sbZero = new StringBuilder();
        StringBuilder sbOne = new StringBuilder();
        StringBuilder sbTwo = new StringBuilder();
        int i;
        for (int k : arr) {
            if (k == 0) {
                sbZero.append(0).append(" ");
            } else if (k == 1) {
                sbOne.append(1).append(" ");
            } else {
                sbTwo.append(2).append(" ");
            }
        }
        System.out.println(sbZero.toString()+sbOne+sbTwo);
    }
}
