package LeetCode.Easy.Strings;

import com.sun.org.apache.regexp.internal.RE;

/**
 *  String to Integer (atoi)
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */
public class Atoi {

    public static void main(String[] args) {
        System.out.println(myAtoi(" 2147483648"));
    }

    /** = 0
     * Very interseting test cases
     * It could be even overlflow needed to handle carefully
     * can be even leading zeroes needed to be handled
     * can be even single negative/positive symbol
     * can be still start with a decimal only
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        long response = 0;

        if(str.isEmpty())
        {
            return 0;
        }
        int i = 0 ;
        while (i<str.length() && str.charAt(i) == ' ')
        {
         i++;
        }

        if(i == str.length())
        {
            return 0;
        }

        boolean isNegative = false;
        if(str.charAt(i)=='-' || str.charAt(i) == '+')
        {
            if(str.charAt(i) == '-') {
                isNegative = true;
            }
            i++;
            if(i==str.length())
            {
                return 0;
            }
        }
        if(Character.isAlphabetic(str.charAt(i)))
        {
            return 0;
        }

        StringBuilder test = new StringBuilder();
        boolean isDecimal = false;
        if(str.charAt(i) == '.')
        {
            isDecimal = true;
            i++;
        }
        while (i<str.length() && str.charAt(i) == '0')
        {
            i++;
        }
        for(;i<str.length();i++)
        {
            if(Character.isDigit(str.charAt(i)))
            {
                test.append(str.charAt(i));
            }
            else {
                break;
            }
        }
        if(isDecimal)
        {
            return 0;
        }
        if(test.toString().isEmpty())
        {
            return 0;
        }
        if(test.toString().length() > 10)
        {
            if(isNegative)
            {
                return Integer.MIN_VALUE;
            }
            else
            {
                return Integer.MAX_VALUE;
            }
        }
        response = Long.parseLong(test.toString());
        response = isNegative ? -response : response;
        if(response > Integer.MAX_VALUE )
        {
            return Integer.MAX_VALUE;
        }
        else if(response < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
        return (int)response;
    }
}
