package Array;

import java.util.Scanner;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note that if you end up using an additional array, you will only receive partial score.
 *
 * Example:
 *
 * If the array is
 *
 * 1 2 3 4 5 6 7 8 9
 *
 * Then the rotated array becomes:
 *
 * 7 4 1 8 5 2 9 6 3
 *
 * Input:
 *
 * The first line contains an integer 'T' denoting the total number of test cases.
 * In each test cases, the first line contains an integer 'N' denoting the size of the 2D square matrix.
 *
 * And in the second line, the elements of the matrix A[][], each separated by a space in row major form.
 *
 *
 * Output:
 *
 * For each test case, print the elements of the rotated array row wise, each element separated by a space. Print the output of each test case in a new line.
 *
 *
 * Constraints:
 *
 * 1 ≤ T ≤ 70
 * 1 ≤ N ≤ 10
 * 1 ≤ A [ i ][ j ] ≤ 100
 *
 *
 * Example:
 *
 * Input:
 *
 * 2
 * 3
 * 1 2 3 4 5 6 7 8 9
 * 2
 * 56 96 91 54
 *
 * Output:
 *
 * 7 4 1 8 5 2 9 6 3
 * 91 56 54 96
 *
 *
 * Solved by iterating columns as col 1 , col 2 .....col n and iterating columns in reverse order
 */
public class Rotate2DArrayWithoutExtraSpace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        while (testCases>0) {
            int numElem = in.nextInt();
            int i, j;

            int[][] matrix = new int[numElem][numElem];
            for (i = 0; i < numElem; i++) {
                for (j = 0; j < numElem; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            for (i = 0; i <numElem; i++) {
                for (j = numElem - 1; j >=0 ; j--) {
                    System.out.print(matrix[j][i] + " ");
                }
            }
            System.out.println();
            testCases--;
        }
    }
}
