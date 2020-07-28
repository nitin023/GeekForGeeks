package GeekForGeeks.Amazon;

/**
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
 * <p>
 * Example 1:
 * <p>
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Medium
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {

        if (s == null || s.length() < 2) {
            if (s.length() < 2) {
                return s.trim();
            }
            return s;
        }

        StringBuilder sb = new StringBuilder(s.length());

        String[] arr = s.split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].isEmpty()) {
                continue;
            }
            if (i != 0) {
                sb.append(arr[i]).append(" ");
            } else {
                sb.append(arr[i]);
            }
        }

        return sb.toString().trim();
    }
}
