package LeetCode.Easy.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagramBestSoln("anam","anma"));
    }

    /**
     * Map method high memory usage
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }

        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        int freq ;
        for(int i = 0 ; i< s.length() ; i++)
        {
            freq = 1;
            if(sMap.containsKey(s.charAt(i)))
            {
                freq+= sMap.get(s.charAt(i));
            }
            sMap.put(s.charAt(i),freq);

            freq = 1;
            if(tMap.containsKey(t.charAt(i)))
            {
                freq+= tMap.get(t.charAt(i));
            }
            tMap.put(t.charAt(i),freq);
        }

        for(Map.Entry<Character,Integer> mk1 : sMap.entrySet())
        {
            if(!tMap.containsKey(mk1.getKey()))
            {
                return false;
            }

            if(!tMap.get(mk1.getKey()).equals(mk1.getValue()))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * low memory method
     *
     * To examine if tt is a rearrangement of ss,
     * we can count occurrences of each letter in the two strings and compare them.
     * Since both ss and tt contain only letters from a-za−z, a simple counter table of size 26 is suffice.
     *
     * Do we need two counter tables for comparison?
     * Actually no, because we could increment the counter for each letter in ss and decrement the counter for each letter in tt,
     * then check if the counter reaches back to zero
     */
    public static boolean isAnagramBestSoln(String s, String t) {

        if(s.length()!=t.length())
        {
            return false;
        }

        int []counter = new int[26];
        for(int i = 0 ; i<s.length() ; i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }

        for (int count : counter){
            if(count!=0)
            {
                return false;
            }
        }
        return true;
    }
}
