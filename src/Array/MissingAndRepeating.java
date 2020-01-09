package Array;

import java.util.*;

/**Find Missing And Repeating
 * Given an unsorted array of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.
 *
 * Note: If you find multiple answers then print the Smallest number found. Also, expected solution is O(n) time and constant extra space.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 *
 * Output:
 * Print B, the repeating number followed by A which is missing in a single line.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 106
 * 1 ≤ A[i] ≤ N
 *
 * Example:
 * Input:
 * 2
 * 2
 * 2 2
 * 3
 * 1 3 3
 *
 * Output:
 * 2 1
 * 3 2
 */
public class MissingAndRepeating {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases  = sc.nextInt();
        while (testCases > 0)
        {
            int num = sc.nextInt();
            int diffAB = 0 , sumAB = 0;
            for(int i = 1 ; i <=num ; i++) {
                int temp =  sc.nextInt();
                diffAB +=temp;
                diffAB -= i;

                sumAB += (temp*temp);
                sumAB -= (i * i );
            }

            sumAB /=diffAB;
            int missingNum = (diffAB + sumAB) / 2;
            System.out.println((sumAB - missingNum) + " " + missingNum);
            testCases--;
        }
    }
}
