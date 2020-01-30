package LeetCode.Easy.Strings;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] input = {"dog",""};
        System.out.println(longestCommonPrefix(input));
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0)
        {
            return "";
        }

        String prefix = strs[0];
        for(int i = 1 ; i < strs.length ; i++)
        {
         String testStr = strs[i];
         StringBuilder updatedPrefix = new StringBuilder();
         for(int j = 0 ; j < prefix.length() && j<testStr.length();j++)
         {
             if(prefix.charAt(j)!=testStr.charAt(j))
             {
                 break;
             }
             updatedPrefix.append(prefix.charAt(j));
         }
         if(updatedPrefix.toString().length()==0)
         {
             return "";
         }
         prefix = updatedPrefix.toString();
        }
        return prefix;
    }
}
