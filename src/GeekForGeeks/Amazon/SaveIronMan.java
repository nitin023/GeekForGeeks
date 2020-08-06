package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Easy
 * https://practice.geeksforgeeks.org/problems/save-ironman/0
 * Simple palindrome check
 */
public class SaveIronMan {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            checkPalindrome(br.readLine());
            testCases--;
        }
    }

    private static void checkPalindrome(String palindromeInput) {
        if (palindromeInput == null || palindromeInput.isEmpty()) {
            System.out.println("YES");
            return;
        }
        palindromeInput = palindromeInput.toLowerCase();
        StringBuilder sb = new StringBuilder(palindromeInput.length());

        for (int k = 0; k < palindromeInput.length(); k++) {
            if (Character.isLetterOrDigit(palindromeInput.charAt(k))) {
                sb.append(palindromeInput.charAt(k));
            }
        }


        String temp = sb.toString();
        int i = 0, j = temp.length() - 1;
        if (temp.length() % 2 == 0) {

            while (i < j) {
                if (temp.charAt(i) != temp.charAt(j)) {
                    System.out.println("NO");
                    return;
                }
                i++;
                j--;
            }
        } else {
            while (i != j) {
                if (temp.charAt(i) != temp.charAt(j)) {
                    System.out.println("NO");
                    return;
                }
                i++;
                j--;
            }
        }
        System.out.println("YES");
    }
}
