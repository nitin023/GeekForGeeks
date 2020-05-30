package Array.BinarySearch;

import sun.font.StandardGlyphVector;

public class FindMinInSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{10,2,3,-4,5,6,7,8}));
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        int mid;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            min = Math.min(nums[low], min);
            min = Math.min(nums[high], min);
            mid = low + (high - low) / 2;
            min = Math.min(nums[mid], min);

            if (nums[mid] <= nums[high]) {
                if (min > nums[mid] && min <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (min < nums[mid] && min >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return min;
    }
}
