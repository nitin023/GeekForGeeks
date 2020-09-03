package GeekForGeeks.Amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/11
 * Medium
 */
public class FindingLongestConsecutiveSequence {
    static int findLongestConsecutiveSequence(int[] nums, int N) {

        int numLongestSubSeq = 0;

        Set<Integer> elementsSet = new HashSet(N);
        for (int item : nums) {
            elementsSet.add(item);
        }

        for (int item : nums) {
            int num = item + 1;
            int cnt = 1;
            if (!elementsSet.contains(item - 1)) {
                while (elementsSet.contains(num)) {
                    num++;
                    cnt++;
                }

                numLongestSubSeq = Math.max(cnt, numLongestSubSeq);
            }
        }

        return numLongestSubSeq;
    }
}
