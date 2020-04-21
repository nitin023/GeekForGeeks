package LeetCode.QueueAndStack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Perfect Squares
 * Solution
 * Given a positive integer n,
 * find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {


    public static void main(String[] args) {
        System.out.println(numSquares(15));
    }

    public static int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedNodes = new HashSet<>();

        queue.add(0);
        visitedNodes.add(0);
        int depth = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            depth++;
            while (queueSize > 0) {
                int currentParentNode = queue.poll();
                for (int i = 1; i * i <= n; i++) {
                    int currentSum = currentParentNode + (i * i);
                    if (currentSum == n) {
                        return depth;
                    }
                    if (currentSum > n) {
                        break;
                    }
                    if (!visitedNodes.contains(currentSum)) {
                        queue.add(currentSum);
                        visitedNodes.add(currentSum);
                    }
                }
                queueSize--;
            }
        }
        return depth;
    }
}
