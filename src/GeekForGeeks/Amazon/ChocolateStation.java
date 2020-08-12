package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Easy
 * https://practice.geeksforgeeks.org/problems/chocolate-station/0
 */
public class ChocolateStation {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            br.readLine();
            String input = br.readLine();
            int cost = Integer.parseInt(br.readLine());
            calculateCostToTravelToLastStation(input, cost);
            testCases--;
        }
    }

    private static void calculateCostToTravelToLastStation(String input, int cost) {

        if (input == null || input.isEmpty()) {
            System.out.println("0");
            return;
        }

        String[] inputList = input.split(" ");
        int[] intList = new int[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            intList[i] = (Integer.parseInt(inputList[i]));
        }
        int CostToTravel = intList[0];
        int freeChocolatesCnt = 0;

        for (int i = 0; i + 1 < intList.length; i++) {
            int diff = intList[i + 1] - intList[i];
            if (intList[i] > intList[i + 1]) {
                freeChocolatesCnt += Math.abs(diff);
            } else {
                int travelCostToStation = diff;
                if (freeChocolatesCnt == 0) {
                    CostToTravel += travelCostToStation;
                } else {
                    if (freeChocolatesCnt > travelCostToStation) {
                        freeChocolatesCnt -= travelCostToStation;
                    } else if (freeChocolatesCnt == travelCostToStation) {
                        freeChocolatesCnt = 0;
                    } else {
                        CostToTravel += travelCostToStation - freeChocolatesCnt;
                        freeChocolatesCnt = 0;
                    }
                }
            }
        }
        System.out.println(CostToTravel * cost);
    }
}
