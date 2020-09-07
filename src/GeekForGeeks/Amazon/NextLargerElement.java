package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/next-larger-element/0
 */
public class NextLargerElement {

    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long a[] = new long[n];

            String s[] = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(s[i]);
            }

            getNextLargerNumberUsingStack(a, n);
        }
    }

    /**
     * Best solution
     *
     * @param arr
     * @param n
     * @not
     * @implNote Algo:
     * 1)While the stack is not empty and the current_element_array
     * is greater than the top_element_of _stack(Basically stack should
     * be sorted ,otherwise pop). Keep popping the
     * top_element_of _stack.Here,current_array_element is the next
     * greatest element of the top_element_of _stack.
     * 2)When popping store this in HashMap as such a
     * pair: (x, next greatest element of x).
     * **3)Now push current_array_element to the stack.
     * 4)Now iterate through the array and get the next greatest element
     * of i , if the next greatest doesn't exist then get it as -1 by default.
     */
    private static void getNextLargerNumberUsingStack(long[] arr, int n) {
        if (n == 0) {
            return;
        }
        Stack<Long> stack = new Stack();
        stack.push(arr[0]);

        HashMap<Long, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                map.put(stack.pop(), arr[i]);
            }
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder(2 * n);
        for (int i = 0; i < n; i++) {
            sb.append(map.getOrDefault(arr[i], -1L)).append(" ");
        }
        System.out.println(sb.toString());
    }

    /**
     * N2 Complexity poor solution
     *
     * @param arr
     * @param n
     */
    private static void getNextLargerNumber(long[] arr, int n) {
        if (n == 0) {
            System.out.println("-1");
        }

        StringBuilder sb = new StringBuilder(2 * n);

        for (int i = 0; i < n; i++) {
            long currItem = arr[i];
            long nextLarger = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > currItem) {
                    nextLarger = arr[j];
                    break;
                }
            }

            sb.append(nextLarger).append(" ");
        }
        System.out.println(sb.toString());
    }

}
