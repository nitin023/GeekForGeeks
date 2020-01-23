package LeetCode.Easy.Strings;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {

    public static void main(FirstUniqueCharInString[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }

    public static void reverseString(char[] s) {

        int startIndex = 0 , endIndex = s.length - 1;
        for(startIndex = 0 ; startIndex<endIndex; startIndex++ ,endIndex--)
        {
            char startChar = s[startIndex];
            s[startIndex] = s[endIndex];
            s[endIndex] = startChar;
        }
    }
}
