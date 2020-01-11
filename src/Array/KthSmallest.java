package Array;

import java.util.*;

/**
 * Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
 *
 * Expected Time Complexity: O(n)
 *
 * Input:
 * The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.
 *
 * Output:
 * Corresponding to each test case, print the kth smallest element in a new line.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 105
 * 1 <= arr[i] <= 105
 * 1 <= K <= N
 *
 * Example:
 * Input:
 * 2
 * 6
 * 7 10 4 3 20 15
 * 3
 * 5
 * 7 10 4 20 15
 * 4
 *
 * Output:
 * 7
 * 15
 */
public class KthSmallest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases > 0)
        {
            int numElem = scanner.nextInt();
            int i;
            List<Integer> nums = new ArrayList<>();

            for(i = 0 ; i< numElem ; i++)
            {
                nums.add(scanner.nextInt());
            }
            int k = scanner.nextInt();
            solutionUsingPriorityQueue(nums,k);
            testCases--;
        }
    }

    /**
     * uses n*k iterations for finding smallest number
     */
    private static void naiveSolution(int [] nums,int k)
    {
        Set<Integer> smallElem = new HashSet<>();
        while (k > 0)
        {
            int minValue = Integer.MAX_VALUE;
            for (int num : nums) {
                if (minValue > num && !smallElem.contains(num)) {
                    minValue = num;
                }
            }
            smallElem.add(minValue);
            k--;
            if(k==0)
            {
                System.out.println(minValue);
            }
        }
    }

    /**
     * Added priority Queue that implements priority heap and
     * using that priority heap we create a heap structure to contain
     * always smallest element at top
     * and we pick that element after K operations
     * @param nums
     * @param k
     */
    private static void solutionUsingPriorityQueue(List<Integer> nums, int k)
    {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums);
        int min = 0;
        while (k>0)
        {
            if(!priorityQueue.isEmpty()) {
                 min = priorityQueue.poll();
            }
            k--;
            if(k==0)
            {
                System.out.println(min);
            }
        }
    }
}
