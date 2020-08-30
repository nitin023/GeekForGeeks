package GeekForGeeks.Amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Easy question
 * //https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 */
public class ConnectRopesWithMinimumCosts {

    public static void main(String[] args) {

        int arr[] = new int[]{4, 3, 2, 6};
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length);
        for (int item : arr) {
            queue.add(item);
        }

        int minCosts = 0;

        while (queue.size() > 1) {
           int num1 = queue.poll();
           int num2 = queue.poll();
           int sum = num1 + num2;
            minCosts += sum;
            queue.add(sum);
        }

        System.out.println(minCosts);
    }
}
