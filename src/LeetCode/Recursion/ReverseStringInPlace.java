package LeetCode.Recursion;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseStringInPlace {

    public static void main(String[] args) {
        reverseString("taiwan".toCharArray());
    }


    public static void reverseString(char[] s) {

        if (s == null) {
            return;
        }

        helperFunc(s, 0, s.length - 1);

    }

    private static void helperFunc(char[] s, int begin, int end) {
        if (begin > end) {
            return;
        }

        char swapper = s[begin];
        s[begin] = s[end];
        s[end] = swapper;

        helperFunc(s, begin + 1, end - 1);
    }
}
