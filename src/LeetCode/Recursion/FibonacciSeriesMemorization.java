package LeetCode.Recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeriesMemorization {

    public static void main(String[] args) {

        Map<Integer, Integer> fibonacciSeries = new HashMap<>();

        System.out.println(  fib(6, fibonacciSeries));
    }

    public static int fib(int N, Map<Integer, Integer> fibonacciSeries) {

        if (fibonacciSeries.containsKey(N)) {
            return fibonacciSeries.get(N);
        }

        if (N < 2) {
            return N;
        }

        int result = fib(N - 1, fibonacciSeries) + fib(N - 2, fibonacciSeries);
        fibonacciSeries.put(N, result);

        return result;
    }
}
