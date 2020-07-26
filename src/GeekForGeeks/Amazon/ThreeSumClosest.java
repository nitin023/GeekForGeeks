package GeekForGeeks.Amazon;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 * https://practice.geeksforgeeks.org/problems/product-array-puzzle0852/1
 * Solution three pointer approach
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        int end;
        int start;
        int sum;

        for (int i = 0; i < nums.length - 2; i++) {
            end = nums.length - 1;
            start = i + 1;
            while (start < end) {
                sum = nums[start] + nums[i] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
