package Array;

import java.util.Arrays;

/**
 * Height Checker
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
 * <p>
 * Notice that when a group of students is selected they can reorder in any possible way between themselves
 * and the non selected students remain on their seats.
 * <p>
 * Example 1:
 * <p>
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Current array : [1,1,4,2,1,3]
 * Target array  : [1,1,1,2,3,4]
 * On index 2 (0-based) we have 4 vs 1 so we have to move this student.
 * On index 4 (0-based) we have 1 vs 3 so we have to move this student.
 * On index 5 (0-based) we have 3 vs 4 so we have to move this student.
 */
public class HeightChecker {

    //O(n) solution fastest
    public int heightCheckerUsingSorting(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] sortedHeights = new int[heights.length];
        System.arraycopy(heights, 0, sortedHeights, 0, heights.length);

        Arrays.sort(sortedHeights);

        int diffInHeightPlacement = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                diffInHeightPlacement++;
            }
        }
        return diffInHeightPlacement;
    }

    //O(n) solution fastest
    public int heightCheckerWithoutSorting(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        int[] sortedHeights = new int[heights.length];

        int j = 0;
        for (int i = 0; i < heightToFreq.length; i++) {
            if (heightToFreq[i] > 0) {
                int freq = heightToFreq[i];
                while (freq > 0) {
                    sortedHeights[j++] = i;
                    freq--;
                }
            }
        }

        int diff = 0;
        for (int k = 0; k < heights.length; k++) {
            if (heights[k] != sortedHeights[k]) {
                diff++;
            }
        }
        return diff;
    }
}
