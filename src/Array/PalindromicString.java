package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Palindrome Permutation
 * A String is called Palindrome if it reads the same backwards as well as forwards.
 * For example, the String  can be read the same backwards as well as forwards.
 * Now, a Permutation of a String S is some String K where S and K contain the same set of characters,
 * however, these characters need not necessarily have the same positions.
 * For Example, consider the String . Here, the Strings :
 * <p>
 * are all permutations of it.
 * <p>
 * Now, given a String S consisting of lowercase English alphabets,
 * you need to find out whether any permutation of this given String is a Palindrome.
 * If yes, print "YES" (Without quotes) else, print "NO" without quotes.
 * <p>
 * Input Format:
 * The first and only line of input contains the String S.
 * <p>
 * Output Format:
 * Print the required answer on a single line
 */
public class PalindromicString {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        try {
            name = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (name == null || name.length() < 2) {
            System.out.println("YES");
        }

        int size = name.length();
        //odd or even check
        Map<Character, Integer> freqMap = new HashMap();

        for (int i = 0; i < size; i++) {
            freqMap.putIfAbsent(name.charAt(i), 0);
            freqMap.put(name.charAt(i), freqMap.get(name.charAt(i)) + 1);
        }

        //even wwr
        if (size % 2 == 0) {
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        } else {
            int cntOneFreq = 0;
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() == 1) {
                    cntOneFreq++;
                } else if (entry.getValue() % 2 != 0) {
                    System.out.println("NO");
                    return;
                }
            }
            if (cntOneFreq == 1) {
                System.out.println("YES");
            }
        }
    }
}
