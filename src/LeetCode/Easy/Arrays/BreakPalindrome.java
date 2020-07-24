package LeetCode.Easy.Arrays;

public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {

        if (palindrome == null || palindrome.length() < 2) {
            return "";
        }

        return getPalindromeBreaking(palindrome);
    }

    private String getPalindromeBreaking(String s) {
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (s.charAt(j) == 'a') {
                j--;
                i++;
            } else {
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[s.length() - 1] = 'b';
        return new String(arr);

    }
}
