package LeetCode.Easy.Strings;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(0));
    }

    /**
     * Iterate all integer while dividing by 10
     * find all reminders and add it to string
     * check for overflow of integer
     * @param x - input
     * @return - converted int
     */
    public static int reverse(int x) {

        if (x == 0) {
            return 0;
        }
        long absoluteX = x;
        absoluteX = Math.abs(absoluteX);
        StringBuilder sb = new StringBuilder();
        while (absoluteX > 0) {
            long reminder = absoluteX % 10;
            sb.append(reminder);
            absoluteX /= 10;
        }

        long resultOverflowCheck = Long.parseLong(sb.toString());
        resultOverflowCheck = x<0 ? -resultOverflowCheck : resultOverflowCheck;
        if (resultOverflowCheck > Integer.MAX_VALUE || resultOverflowCheck < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)resultOverflowCheck;
    }
}
