package GeekForGeeks.Amazon;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
 * Union of Two Sorted Arrays
 *
 * Used logic of merging two sorted arrays and for unique elements added set
 * complexity : O(m+n)
 */
public class UnionOfTwoSortedArray {

    public static void main(String[] args) {
        findUnion(
                new int[]{1 , 1 , 3 , 6 , 6 , 12 , 13 , 18 , 25 , 32 , 37 , 37 , 41 , 42} ,
                new int[]{4 , 8 , 8 , 8 , 9 , 10 , 10 , 17 , 22 , 23 , 25 , 31 , 34 , 38 , 38 , 39 , 42 , 46} ,
                14 , 18);
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {

        // add your code here
        if (m == 0 && n == 0) {
            return new ArrayList();
        } else if (m == 0 && n != 0) {
            return new ArrayList(Arrays.asList(arr2));
        } else if (n == 0 && m != 0) {
            return new ArrayList(Arrays.asList(arr1));
        }


        ArrayList<Integer> list = new ArrayList(m + n);

        int low1 = 0, low2 = 0, high1 = n, high2 = m;
        Set<Integer> valuesAdded = new HashSet();

        while (low1 < high1 && low2 < high2) {
            while (low1 < high1 && valuesAdded.contains(arr1[low1])) {
                low1++;
            }
            while (low2 < high2 && valuesAdded.contains(arr2[low2])) {
                low2++;
            }

            if (low1 < high1 && low2 < high2) {
                int value1 = arr1[low1];
                int value2 = arr2[low2];

                if (value1 < value2) {
                    list.add(value1);
                    low1++;
                    valuesAdded.add(value1);
                } else if (value1 == value2) {
                    list.add(value2);
                    low1++;
                    low2++;
                    valuesAdded.add(value2);
                } else {
                    list.add(value2);
                    low2++;
                    valuesAdded.add(value2);
                }
            }
        }

        while (low1 < high1) {
            if (!valuesAdded.contains(arr1[low1])) {
                valuesAdded.add(arr1[low1]);
                list.add(arr1[low1]);
            }
            low1++;
        }

        while (low2 < high2) {
            if (!valuesAdded.contains(arr2[low2])) {
                valuesAdded.add(arr2[low2]);
                list.add(arr2[low2]);
            }
            low2++;
        }

        return list;
    }
}
