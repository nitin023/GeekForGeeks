package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Easy
 * https://practice.geeksforgeeks.org/problems/elements-in-the-range/0
 */
public class ElementsInRange {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            String target = br.readLine();
            int numElem = Integer.parseInt(target.split(" ")[0]);
            int rangeStart = Integer.parseInt(target.split(" ")[1]);
            int rangeEnd = Integer.parseInt(target.split(" ")[2]);

            String inputLine = br.readLine();

            findIfElementsInRange(numElem, rangeStart, rangeEnd, inputLine);
            testCases--;
        }
    }

    private static void findIfElementsInRange(int numElem, int rangeStart, int rangeEnd, String inputLine) {
        if (inputLine == null || inputLine.isEmpty()) {
            System.out.println("No");
            return;
        }

        String[] inputStrArr = inputLine.split(" ");
        int val;
        int count = 0;

        for (int i = 0; i < numElem; i++) {
            val = Integer.parseInt(inputStrArr[i]);
            if (rangeStart <= val && rangeEnd >= val) {
                count++;
            }
        }

        if (count == (rangeEnd - rangeStart + 1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
