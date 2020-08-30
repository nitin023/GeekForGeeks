package GeekForGeeks.Amazon;

import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * Medium
 * Heaps
 */
public class NearlySortedArray {

    public static void main(String[] args) {
        sortNearlySortedArray(new int[]{6, 5, 3, 2, 8, 10, 9}, 3);
    }

    private static void sortNearlySortedArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length);
        int i, j;
        for (i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        for (j = k + 1; j < arr.length; j++) {
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[j]);
        }
        while (!priorityQueue.isEmpty()) {
            arr[index++] = priorityQueue.poll();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                stringBuilder.append(arr[i]).append(",");
            } else {
                stringBuilder.append(arr[i]);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
