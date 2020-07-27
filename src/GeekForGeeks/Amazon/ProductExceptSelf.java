package GeekForGeeks.Amazon;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1
 *
 * Solution :: In question specifically said we cannot divide that means we resort to only multiplication
 * we split the array into two parts for any specific index
 * let say to calculate left prod for index i and right product for the index
 * then upon multiplying left values of index * right values of index we can get the product of all except the index
 *
 * left array is cal from i-1 to n and right is cal from num.length - 1 to 0
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] response = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            response[i] = left[i] * right[i];
        }
        return response;
    }
}
