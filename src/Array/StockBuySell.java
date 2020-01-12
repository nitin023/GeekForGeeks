package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
 * <p>
 * Input:
 * First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days.
 * <p>
 * Output:
 * For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 2 <= N <= 103
 * 0 <= Ai <= 104
 * <p>
 * Example
 * Input:
 * 2
 * 7
 * 100 180 260 310 40 535 695
 * 10
 * 23 13 25 29 33 19 34 45 65 67
 * <p>
 * Output:
 * (0 3) (4 6)
 * (1 4) (5 9)
 * <p>
 * Explanation:
 * Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.
 */
public class StockBuySell {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());
        while (testCases > 0) {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<Integer> stockPriceList = new ArrayList<>();
            while (st.hasMoreElements()) {
                stockPriceList.add(Integer.parseInt(st.nextToken()));
            }
            calculateStockProfit(stockPriceList, numElem);
            testCases--;
        }
    }

    /**
     * Stock buy and sell
     * Simple found out in which indexes sequence increases
     *
     * @param stockPriceList
     * @param numElem
     */
    private static void calculateStockProfit(List<Integer> stockPriceList, int numElem) {
        boolean isProfitExists = false;
        for (int i = 0; i + 1 < numElem; i++) {
            if (stockPriceList.get(i) < stockPriceList.get(i + 1)) {
                int j = i;
                while (j + 1 < numElem && stockPriceList.get(j) < stockPriceList.get(j + 1)) {
                    j++;
                }
                isProfitExists = true;
                System.out.print("(" + i + " " + j + ") ");
                i = j;
            }
        }
        if (!isProfitExists)
            System.out.print("No Profit");

        System.out.println();
    }
}
