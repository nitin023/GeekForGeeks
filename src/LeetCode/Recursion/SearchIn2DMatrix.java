package LeetCode.Recursion;

import java.util.Arrays;

/**
 * Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false
 */
public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {},
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        for (int[] ints : matrix) {
            if ( ints.length>0 && target>=ints[0] &&  target <= ints[ints.length - 1]) {
                int index = Arrays.binarySearch(ints, target);
                if (index >= 0 && index < ints.length) {
                    return true;
                }
            }
        }
        return false;
    }

}
