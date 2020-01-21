package LeetCode.Easy.Arrays;

import java.util.*;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        int []nums = {3,3};
        twoSumInLeetCode(nums,6);
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] response = new int[2];
        Map<Integer, Set<Integer>> valueIndexMap = new HashMap<>();

        Set<Integer> set ;
        for(int i = 0 ; i < nums.length ; i++)
        {
            set = new HashSet<>();
            if(valueIndexMap.containsKey(nums[i]))
            {
                set = valueIndexMap.get(nums[i]);
            }
            set.add(i);
            valueIndexMap.put(nums[i],set);
        }

        Set<Integer>resultSet = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            int number = nums[i];
            int pairPart = target - number;
            if(valueIndexMap.containsKey(pairPart))
            {
                set = valueIndexMap.get(pairPart);
                List<Integer> tempL = new ArrayList(set);
                if(tempL.size() ==1 && i!=tempL.get(0)) {
                    resultSet.add(i);
                    resultSet.add(tempL.get(0));
                    break;
                }
                else if(tempL.size() > 1)
                {
                    resultSet.add(i);
                    resultSet.addAll(tempL);
                    break;
                }
            }
        }

        int p = 0;
        for(long item : resultSet)
        {
            if(p>1)
            {
                break;
            }
            response[p++] = (int)item;
        }
        return response;
    }

    public static int[] twoSumInLeetCode(int []nums , int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement))
            {
                return new int[] {i , map.get(complement)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
