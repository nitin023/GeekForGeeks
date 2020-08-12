package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Easy Problem
 * Can be solved just by breaking elements into two separate Lists if item > 0
 * add it to positive list
 * else add it to negative list
 * then just append the two list alternatively
 * https://practice.geeksforgeeks.org/problems/positive-and-negative-elements/0
 */
public class SeparateIntoPositiveAndNegativeList {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            br.readLine();
            arrangeArray(br.readLine());
            testCases--;
        }
    }

    private static void arrangeArray(String inputStream) {
        if (inputStream == null || inputStream.isEmpty()) {
            return;
        }

        String[] input = inputStream.split(" ");
        StringBuilder sb = new StringBuilder(input.length);
        List<String> positiveList = new ArrayList<>(input.length);
        List<String> negativeList = new ArrayList<>(input.length);

        for (int i = 0; i < input.length; i++) {
            int item = Integer.parseInt(input[i].trim());
            if (item > 0) {
                positiveList.add(input[i]);
            } else {
                negativeList.add(input[i]);
            }
        }

        int i = 0, j = 0;
        while (i < positiveList.size() || j < negativeList.size()) {
            if (i < positiveList.size()) {
                sb.append(positiveList.get(i)).append(" ");
                i++;
            }
            if (j < negativeList.size()) {
                sb.append(negativeList.get(j)).append(" ");
                j++;
            }
        }
        System.out.println(sb.toString().trim());
    }
}
