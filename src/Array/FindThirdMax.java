package Array;

public class FindThirdMax {

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2,-2147483648}));
    }

    public static int thirdMax(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        boolean isMinIntegerPresent = false;

        for (int item : nums) {
            if(item == Integer.MIN_VALUE)
            {
                isMinIntegerPresent = true;
            }
            if (firstMax < item) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = item;
            } else if (secondMax < item && firstMax > item) {
                thirdMax = secondMax;
                secondMax = item;
            } else if (thirdMax < item && secondMax > item) {
                thirdMax = item;
            }
        }

        if (firstMax > secondMax && secondMax > thirdMax) {
            if (!isMinIntegerPresent) {
                if (secondMax == Integer.MIN_VALUE || thirdMax == Integer.MIN_VALUE) {
                    return firstMax;
                }
            }
            return thirdMax;
        }
        return firstMax;
    }
}
