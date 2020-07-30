package GeekForGeeks.Amazon;

/**
 * Binary String
 * https://practice.geeksforgeeks.org/problems/binary-string-1587115620/1
 * Easy problem
 * <p>
 * n * (n-1) / 2
 */
public class BinaryStrings {

    public static int binarySubstring(int a, String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int numOnes = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                numOnes++;
            }
        }

        return (numOnes * (numOnes - 1)) / 2;
    }
}
