package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
 * <p>
 * Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times will not be same for a train, but we can have arrival time of one train equal to departure of the other.
 * <p>
 * In such cases, we need different platforms, i.e at any given instance of time, same platform can not be used for both departure of a train and arrival of another.
 * <p>
 * Input:
 * The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
 * Note: Time intervals are in the 24-hour format(hhmm),  of the for HHMM , where the first two charcters represent hour (between 00 to 23 ) and last two characters represent minutes (between 00 to 59).
 * <p>
 * Output:
 * For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 1000
 * 1 <= A[i] < D[i] <= 2359
 * <p>
 * Example:
 * Input:
 * 2
 * 6
 * 0900  0940 0950  1100 1500 1800
 * 0910 1200 1120 1130 1900 2000
 * 3
 * 0900 1100 1235
 * 1000 1200 1240
 * <p>
 * Output:
 * 3
 * 1
 */
public class MinimumPlatforms {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());
        while (testCases > 0) {
            st = new StringTokenizer(br.readLine());
            int numTrains = Integer.parseInt(st.nextToken());
            List<Integer> arrivalTime = new ArrayList<>();
            List<Integer> departTime = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                arrivalTime.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                departTime.add(Integer.parseInt(st.nextToken()));
            }
            calculateMinNumPlatFormsGreedily(arrivalTime, departTime);
            testCases--;
        }
    }

    private static void calculateMinNumPlatFormsGreedily(List<Integer> arrivalTime, List<Integer> departTime) {
        Collections.sort(arrivalTime);
        Collections.sort(departTime);
        int i = 0, j = 0;
        int minPlat = 0, k = 0;
        while (i < arrivalTime.size() && j < arrivalTime.size()) {
            if (arrivalTime.get(i) <= departTime.get(j)) {
                k++;
                i++;
            } else {
                k--;
                j++;
            }
            minPlat = Math.max(minPlat, k);
        }
        System.out.println(minPlat);
    }
}
