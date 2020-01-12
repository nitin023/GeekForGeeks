package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
 * Note: Expected solution in O(n) time using constant extra space.
 * <p>
 * Input:
 * First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. Second line of every test case consists of elements in array.
 * <p>
 * Output:
 * Single line output, print the smallest positive number missing.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 106
 * -106 <= arr[i] <= 106
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 5
 * 0 -10 1 3 -20
 * Output:
 * 6
 * 2
 * <p>
 * Explanation:
 * Testcase 1: Smallest positive missing number is 6.
 * Testcase 2: Smallest positive missing number is 2.
 */
public class SmallestPositiveMissingNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<Integer> nums = new ArrayList<>();
            while (st.hasMoreElements()) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            getSmallestPositiveMissingNumber(nums);
            testCases--;
        }
    }

    private static void getSmallestPositiveMissingNumber(List<Integer> nums) {
        int minimumPositive = Integer.MAX_VALUE;
        int maximumPositive = Integer.MIN_VALUE;

        Set<Integer> positiveSet = new HashSet<>();
        for (int item : nums) {
            if (item > 0) {
                positiveSet.add(item);
                if (minimumPositive > item) {
                    minimumPositive = item;
                }

                if (maximumPositive < item) {
                    maximumPositive = item;
                }
            }
        }

        if(minimumPositive!=1)
        {
            System.out.println(1);
            return;
        }
        for(int i = minimumPositive ; i <= maximumPositive ; i++)
        {
            if(!positiveSet.contains(i))
            {
                System.out.println(i);
                return;
            }
        }

        System.out.println(Math.abs(maximumPositive+1));
    }
}
