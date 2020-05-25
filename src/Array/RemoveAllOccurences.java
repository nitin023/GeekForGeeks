package Array;

/**
 * Remove Element
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 */
public class RemoveAllOccurences {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    public static int removeElement(int[] nums, int val) {

        int newLength = 0;
        int elemRemoved = 0;

        for(int i = 0 ; i < nums.length  - elemRemoved; )
        {
            if(nums[i]==val)
            {
                int index = i;
                while (index +1 < nums.length)
                {
                    nums[index] = nums[index+1];
                    index++;
                }
                elemRemoved++;
            }
            else
            {
                newLength++;
                i++;
            }
        }
        return newLength;
    }
}
