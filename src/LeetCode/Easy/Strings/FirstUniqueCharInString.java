package LeetCode.Easy.Strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * First Unique Character in a String
 * Solution
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharInString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar(""));
    }

    public static int firstUniqChar(String s) {
        Map<Character, List<Integer>> uniqueCharFreq = new LinkedHashMap<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            List<Integer> indexList = new ArrayList<>();
            if(uniqueCharFreq.containsKey(s.charAt(i)))
            {
                 indexList =  uniqueCharFreq.get(s.charAt(i));
            }
            indexList.add(i);
            uniqueCharFreq.put(s.charAt(i),indexList);
        }

        for (Map.Entry<Character,List<Integer>> mk : uniqueCharFreq.entrySet())
        {
            if(mk.getValue().size() == 1)
            {
                return mk.getValue().get(0);
            }
        }
        return -1;
     }
}
