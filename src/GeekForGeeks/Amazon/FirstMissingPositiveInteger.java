package GeekForGeeks.Amazon;

import java.util.Arrays;

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 * https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
 */
public class FirstMissingPositiveInteger {

    public int firstMissingPositive(int[] nums) {

        if (nums.length == 0) {
            return 1;
        }

        Arrays.sort(nums);
        if (nums[0] > 1) {
            return 1;
        }

        int missingNumber = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (missingNumber == nums[i]) {
                    missingNumber += 1;
                }
            }
        }

        return missingNumber;
    }
}
