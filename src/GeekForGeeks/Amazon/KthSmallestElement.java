package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
 * Easy
 */
public class KthSmallestElement {
    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            String input = br.readLine();
            int numElem = Integer.parseInt(input);


            String[] arr = br.readLine().split(" ");
            int numKElem = Integer.parseInt(br.readLine());
            getKthSmallestNumber(arr, numElem, numKElem);
            testCases--;
        }
    }

    private static void getKthSmallestNumber(String[] arr, int numElem, int numKElem) {
        PriorityQueue<Integer> queue = new PriorityQueue(numElem);
        for (String item : arr) {
            queue.add(Integer.parseInt(item));
        }

        int value = -1;

        while (numKElem > 0 && !queue.isEmpty()) {
            value = queue.poll();
            numKElem--;
        }
        System.out.println(value);
    }
}
