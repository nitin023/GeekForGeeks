package GeekForGeeks.Amazon;

/**
 * https://practice.geeksforgeeks.org/problems/betting-game/0
 * Medium
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BettingGame {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            String target = br.readLine();

            getWinOrDefeatSum(target);
            testCases--;
        }
    }

    private static void getWinOrDefeatSum(String target) {

        if (target == null || target.isEmpty()) {
            System.out.println("-1");
            return;
        }

        int currentSum = 4, bettingAmount = 1;
        for (int i = 0; i < target.length(); i++) {
            char winOrLoss = target.charAt(i);
            if (winOrLoss == 'W') {
                if (currentSum < bettingAmount) {
                    currentSum = -1;
                    break;
                }
                currentSum += bettingAmount;
                bettingAmount = 1;
            } else {
                if (currentSum - bettingAmount >= 0) {
                    currentSum -= bettingAmount;
                    bettingAmount *= 2;
                } else {
                    currentSum -= bettingAmount;
                    break;
                }
            }
        }
        System.out.println(currentSum >= 0 ? currentSum : -1);
    }
}
