package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://practice.geeksforgeeks.org/problems/sum-of-numbers-or-number/0
 * easy
 * Adding Two Big numbers
 * Normally adding numbers with 100 digits at max may produce overflow exception
 * Start converting number two strings
 * and follows adding digit by digit if any carry is generated then adjust it to next available digit
 * else store the sum
 */
public class SumOFBigNumbers {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            sumBigIntegers(br.readLine());
            testCases--;
        }
    }

    private static void sumBigIntegers(String inputLine) {
        String[] input = inputLine.split(" ");

        String number1 = input[0].trim();
        String number2 = input[1].trim();


        StringBuilder sb = new StringBuilder(number1.length() + 1);

        int i = number1.length() - 1, j = number2.length() - 1;
        boolean carry = false;

        while (i >= 0 || j >= 0 || carry) {
            int sum = (i >= 0 ? number1.charAt(i--) - '0' : 0) + (j >= 0 ? number2.charAt(j--) - '0' : 0) + (carry ? 1 : 0);
            if (sum > 9) {
                sb.append(sum - 10);
                carry = true;
            } else {
                carry = false;
                sb.append(sum);
            }
        }

        if (sb.length() == number1.length()) {
            System.out.println(sb.reverse().toString());
        } else {
            System.out.println(number1);
        }
    }
}
