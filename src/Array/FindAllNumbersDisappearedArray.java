package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Numbers Disappeared in an Array
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedArray {

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(1);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int[] numFreqMap = new int[nums.length + 1];
        for (int val : nums) {
            numFreqMap[val]++;
        }

        List<Integer> missingIntegers = new ArrayList<>();
        for (int i = 1; i < numFreqMap.length; i++) {
            if (numFreqMap[i] == 0) {
                missingIntegers.add(i);
            }
        }
        return missingIntegers;
    }
}
