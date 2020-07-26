package GeekForGeeks.Amazon;

/**
 * 75. Sort Colors
 * https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 */
public class SortColors {
    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        int numZeroes = 0, numOnes = 0, numTwos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeroes++;
            } else if (nums[i] == 1) {
                numOnes++;
            } else {
                numTwos++;
            }
        }

        int i = 0;
        while (numZeroes > 0) {
            nums[i++] = 0;
            numZeroes--;
        }
        while (numOnes > 0) {
            nums[i++] = 1;
            numOnes--;
        }
        while (numTwos > 0) {
            nums[i++] = 2;
            numTwos--;
        }
    }
}
