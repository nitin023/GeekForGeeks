package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Count Occurences of Anagrams
 * Given a word S and a text C. Return the count of the occurences of anagrams of the word in the text.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a text S consisting of only lowercase characters.
 * The second line contains a word consisting of only lowercase characters.
 *
 * Output:
 * Print the count of the occurences of anagrams of the word C in the text S.
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= |S| <= |C| <= 50
 *
 * Example:
 * Input:
 * 2
 * forxxorfxdofr
 * for
 * aabaabaa
 * aaba
 *
 * Output:
 * 3
 * 4
 */
public class AnagramOccurrence {

    public static void main(String[] args) {

        //naiveSolution();
        timeWindowApproach();
    }

    /**
     * This picks sub-string one by one and matches for anagram
     * while employing sorting technique for anagram matching
     */
    private static void naiveSolution()
    {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        while (testCases>0) {
            String word = sc.next();
            String text = sc.next();
            char [] textArr = text.toCharArray();
            Arrays.sort(textArr);
            text = String.valueOf(textArr);

            int textLen = text.length();
            int anagramCnt = 0;
            for(int i = 0 ; i+textLen <=word.length() ; i++)
            {
                String currentAnagram = word.substring(i , i+textLen);
                textArr = currentAnagram.toCharArray();
                Arrays.sort(textArr);
                currentAnagram = String.valueOf(textArr);

                if(currentAnagram.equals(text))
                {
                    anagramCnt++;
                }
            }
            System.out.println(anagramCnt);
            testCases--;
        }
    }

    final static int MAX_CHAR = 256;

    private static void timeWindowApproach()
    {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        while (testCases>0) {
            String word = sc.next();
            String text = sc.next();
            countAnagrams(word,text);
            testCases--;
        }
    }

   private static void countAnagrams(String text, String word)
    {
        int N = text.length();
        int n = word.length();

        // Check for first window. The idea is to
        // use single count array to match counts
        int[] count = new int[MAX_CHAR];
        for (int i = 0; i < n; i++)
            count[word.charAt(i)]++;
        for (int i = 0; i < n; i++)
            count[text.charAt(i)]--;

        // If first window itself is anagram
        int res = 0;
        if (isCountZero(count))
            res++;

        for (int i = n; i < N; i++) {

            // Add last character of current
            // window
            count[text.charAt(i)]--;

            // Remove first character of previous
            // window.
            count[text.charAt(i - n)]++;

            // If count array is 0, we found an
            // anagram.
            if (isCountZero(count))
                res++;
        }
        System.out.println(res);
    }
    // Function to find if two strings are equal
    private static boolean isCountZero(int[] count)
    {
        for (int i = 0; i < MAX_CHAR; i++)
            if (count[i] != 0)
                return false;
        return true;
    }
}
