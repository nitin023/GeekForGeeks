package Array;

/**
 * Move Zeroes
 * Given an array nums,
 * write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0});
    }

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int i = 0, j = 0;

        while (i < nums.length) {
            if (nums[i] == 0) {
                j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j < nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            i++;
        }
    }
}
