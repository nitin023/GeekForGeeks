package LeetCode.Easy.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int [] nums = {20,1,10,3,12};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {

        int numZeroes = 0;
        int i , j = 0;

        for(i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] == 0)
            {
                numZeroes++;
            }
            else
            {
                nums[j++] = nums[i];
            }
        }

        if(numZeroes > 0)
        {
            j = nums.length - numZeroes;
            while (j<nums.length)
            {
                nums[j++] = 0;
            }
        }
    }
}
