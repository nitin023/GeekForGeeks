package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Easy
 * GFG
 * https://practice.geeksforgeeks.org/problems/pairs-with-positive-negative-values/0
 * Approach
 * Find unique elements having a pair whose sum = 0
 * after that iterate over unique set to create a unique list
 * sort the list and create output following -ve then +ve number
 */
public class PairsWithPositiveNegativeValue {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            br.readLine();
            getPairsIfExists(br.readLine());
            testCases--;
        }
    }

    private static void getPairsIfExists(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("0");
            return;
        }

        String[] arr = input.split(" ");

        Set<Integer> listPairs = new HashSet(arr.length);
        for (int i = 0; i < arr.length; i++) {
            String number = arr[i].trim();
            int value = Integer.parseInt(number);
            listPairs.add(value);
        }

        Set<Integer> uniquePairsSet = new HashSet(listPairs.size());

        for (int item : listPairs) {
            int numDoExists = -item;
            if (listPairs.contains(numDoExists)) {
                uniquePairsSet.add(Math.abs(item));
            }
        }

        if (uniquePairsSet.size() == 0) {
            System.out.println("0");
            return;
        } else {
            List<Integer> shuffledList = new ArrayList<>(uniquePairsSet);
            Collections.sort(shuffledList);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < shuffledList.size(); i++) {
                sb.append("-").append(shuffledList.get(i)).append(" ").append(shuffledList.get(i)).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
