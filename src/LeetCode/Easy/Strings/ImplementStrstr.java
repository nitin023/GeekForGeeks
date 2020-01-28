package LeetCode.Easy.Strings;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi"
                ,"issipp"));
    }

    /**
     * Index of operation takes
     * o(m+n) in average cases while it takes o(m*n)
     * in worst cases
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.isEmpty()) {
            return -1;
        }

        if(needle.length() > haystack.length())
        {
            return -1;
        }

      return haystack.indexOf(needle);
    }
}
