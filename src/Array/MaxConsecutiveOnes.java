package Array;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxNumberConsecutiveOnes = 0;

        for (int i = 0; i < nums.length; ) {
            int tempMaxOnes = 0;
            if (nums[i] == 1) {
                while (i < nums.length && nums[i] == 1) {
                    i++;
                    tempMaxOnes++;
                }
                if (maxNumberConsecutiveOnes < tempMaxOnes) {
                    maxNumberConsecutiveOnes = tempMaxOnes;
                }
            } else {
                i++;
            }
        }
        return maxNumberConsecutiveOnes;
    }
}
