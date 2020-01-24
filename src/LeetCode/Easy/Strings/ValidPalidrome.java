package LeetCode.Easy.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class ValidPalidrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        StringBuilder onlyCharString = new StringBuilder();
        for(int i = 0 ; i<s.length() ; i++)
        {
            char item = Character.toLowerCase(s.charAt(i));
            if(Character.isDigit(item) || Character.isAlphabetic(item))
            {
                onlyCharString.append(item);
            }
        }

        for(int i = 0 , j = onlyCharString.length() - 1 ; i<onlyCharString.length() && i!=j ; i++ , j--)
        {
            char startDirChar = onlyCharString.charAt(i);
            char endDirChar = onlyCharString.charAt(j);
            if(startDirChar!=endDirChar)
            {
                return false;
            }
        }
        return true;
    }

}
