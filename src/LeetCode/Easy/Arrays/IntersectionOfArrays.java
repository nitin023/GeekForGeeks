package LeetCode.Easy.Arrays;

import java.util.*;

/**
 * Intersection of Two Arrays II
 * Solution
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfArrays {

    public static void main(String[] args) {
        int []nums1 = {1,2,2,1};
        int []nums2 = {1,2,1};
        intersectionUsingSorting(nums1,nums2);
    }

    public static void intersectUsingHashMap(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = GetNumsMap(nums1);
        Map<Integer, Integer> map2  = GetNumsMap(nums2);


        List<Integer> list = new ArrayList();
        for(Map.Entry<Integer,Integer> m : map1.entrySet())
        {
            if(map2.containsKey(m.getKey()))
            {
                int freq = Math.min(m.getValue() , map2.get(m.getKey()));
                while(freq>0)
                {
                    list.add(m.getKey());
                    freq--;
                }
            }
        }

        Object[] objects = list.toArray();
        int [] result = new int[list.size()];

        int j = 0;
        for(Object o : objects)
        {
            result[j++] = (int)o;
        }

    }

    private static Map<Integer,Integer>  GetNumsMap(int[] nums1) {
        Map<Integer,Integer> map1 = new HashMap();
        for(int i : nums1)
        {
            int freq = 1;
            if(map1.containsKey(i))
            {
                freq += map1.get(i);
            }
            map1.put(i,freq);
        }
        return map1;
    }

    /**
     * To find intersection of 2 sorted arrays, follow the below approach :
     *
     * 1) Use two index variables i and j, initial values i = 0, j = 0
     * 2) If arr1[i] is smaller than arr2[j] then increment i.
     * 3) If arr1[i] is greater than arr2[j] then increment j.
     * 4) If both are same then print any of them and increment both i and j.
     *
     * Complexity O(m+n)
     * @param nums1
     * @param nums2
     */
    private static void intersectionUsingSorting(int [] nums1 , int [] nums2)
    {
        List<Integer> commonElem = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i  = 0, j = 0 ;
        while (i<nums1.length && j <nums2.length)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                commonElem.add(nums1[i]);
                i++;j++;
            }
        }

        for (int item : commonElem)
        {
            System.out.print(item + " ");
        }
    }
}
