package GeekForGeeks.Amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1
 * https://leetcode.com/problems/intersection-of-two-arrays/submissions/
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> response = new HashSet();

        Set<Integer> numSet = new HashSet();

        for (int i = 0; i < nums1.length; i++) {
            numSet.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (numSet.contains(nums2[i])) {
                response.add(nums2[i]);
            }
        }

        int[] responseArr = new int[response.size()];
        int i = 0;
        for (int item : response) {
            responseArr[i++] = item;
        }
        return responseArr;
    }
}
