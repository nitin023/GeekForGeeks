package LeetCode.Easy.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */

public class RotateMatrixBy90 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(matrix);
    }

    /**
     * In place solution without using extra space
     * first get transpose
     * after transpose reverse the rows to get rotation
     * @param matrix
     */
    public static void rotate(int[][] matrix) {

        //take transpose of matrix
        int i  = 1 , j = 0 ,k = 0 , numElem = matrix.length;
        int a;
        while (k < numElem - 1)
        {
             a = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = a;

            if(i==numElem-1 || j==numElem-1)
            {
                k++;
                i=k; j=k;
                i++;
            }
            else
            {
                i++;
            }
        }

       i = 0;

        int times = numElem/2;
        while (i<numElem)
        {
            int p = 1;
            for(j = 0 , k=numElem-1; j < numElem && p<=times; j++,k--,p++)
            {
                a = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = a;
            }
            i++;
        }
    }
}
