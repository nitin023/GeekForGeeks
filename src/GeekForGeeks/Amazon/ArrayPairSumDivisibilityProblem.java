package GeekForGeeks.Amazon;

//https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem/0

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Medium but skip
 */
public class ArrayPairSumDivisibilityProblem {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            int numElem = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine());
            if (getPairAvailability(numElem, input, k)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
            testCases--;
        }
    }

    private static boolean getPairAvailability(int numElem, String[] input, int k) {
        if (numElem % 2 == 1)
            return false;
        Map<Integer, Integer> map = new HashMap<>(input.length);
        List<Integer> integerList = new ArrayList<>(numElem);
        for (String item : input) {
            int temp = Integer.parseInt(item);
            integerList.add(temp);
            int rem = temp % k;
            map.putIfAbsent(rem, 0);
            map.put(rem, map.get(rem) + 1);
        }

        for (int item : integerList) {
            int rem = item % k;

            if (2 * rem == k) {
                if ( map.get(rem) % 2 == 1) {
                    return false;
                }
            } else if (rem == 0) {
                if (map.get(rem) % 2 == 1) {
                    return false;
                }
            } else {
                if (!map.containsKey(k-rem) || !map.get(k - rem).equals(map.get(rem))) {
                    return false;
                }
            }
        }
        return true;
    }
}
