package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23453444"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> response = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return response;
        }

        Map<Integer, String> keypadValueMap = new HashMap<>();

        keypadValueMap.put(2, "abc");
        keypadValueMap.put(3, "def");
        keypadValueMap.put(4, "ghi");
        keypadValueMap.put(5, "jkl");
        keypadValueMap.put(6, "mno");
        keypadValueMap.put(7, "pqrs");
        keypadValueMap.put(8, "tuv");
        keypadValueMap.put(9, "wxyz");

        char firstChar = digits.charAt(0);
        String value = keypadValueMap.get(firstChar - '0');
        for (char item : value.toCharArray()) {
            response.add(String.valueOf(item));
        }

        for(int i = 1 ; i < digits.length() ; i++)
        {
            firstChar = digits.charAt(i);
            value = keypadValueMap.get(firstChar - '0');
            List<String>tempResponse = new ArrayList<>();

            for(String entry : response)
            {
                for(char val : value.toCharArray())
                {
                    tempResponse.add(entry+val);
                }
            }
            response.clear();
            response.addAll(tempResponse);
        }
        return response;
    }
}
