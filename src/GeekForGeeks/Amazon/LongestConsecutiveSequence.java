package GeekForGeeks.Amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Hard
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 * <p>
 * Problem Solving approach
 * whenever we look into the series we are given unsorted data
 * but when we check any elem and its next elem is present we should
 * keep iterating it until we get break in the sequence
 * this can be done using a hashset
 * picking elem one by one and looking its other relevant values inside the series
 * if the relevant values are present that means a sequence exists
 * <p>
 * we try to check the preceding value inside sequence so as we don't eval same series again and again
 * this way we pick only tip of the series
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> numSet = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int maxCnt = 1;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int tempCnt = 1;

                int i = num + 1;
                while (numSet.contains(i)) {
                    i++;
                    tempCnt++;
                }

                maxCnt = Math.max(maxCnt, tempCnt);
            }
        }

        return maxCnt;
    }
}
