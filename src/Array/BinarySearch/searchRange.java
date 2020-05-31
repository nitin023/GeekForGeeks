package Array.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class searchRange {

    public static void main(String[] args) {
        searchRange(new int[]{3,3}
        ,3);
    }

    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1) {
          return (nums[0]==target) ?  new int[]{0, 0} :  new int[]{-1,-1};
        }

        int low = 0, high = nums.length - 1, mid;

        List<Integer> targetIndexList = new ArrayList();

        while (low  <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                int lMid = mid ;
                int rightMid = mid ;

                while (lMid >= 0) {
                    if (nums[lMid] == target) {
                        lMid--;
                    } else {
                        break;
                    }
                }
                while (rightMid < nums.length) {
                    if (nums[rightMid] == target) {
                        rightMid++;
                    } else {
                        break;
                    }
                }
                targetIndexList.add(lMid+1);
                targetIndexList.add(rightMid-1);
                break;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (targetIndexList.isEmpty()) {
            return new int[]{-1, -1};
        }

        int[] array = new int[2];
        array[0] = targetIndexList.get(0);
        array[1] = targetIndexList.get(targetIndexList.size()-1);
        return array;
    }
}

