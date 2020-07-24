package LeetCode.Easy.Arrays;

import java.util.Collections;

public class Doubly {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return;
        }
        getTranspose(matrix);

    }

    private static void getTranspose(int[][] matrix) {
        int row = 0, col = 0;

        int length = matrix.length;

        while (row < length || col < length) {
            int colSwap = col;
            while (colSwap < length) {
                //transform by swapping
                int x = matrix[row][colSwap];
                matrix[row][colSwap] = matrix[colSwap][row];
                matrix[colSwap][row] = x;
                colSwap++;
            }
            row++;
            col++;
        }
        reverseReadFromColumn(matrix);
    }

    private static void reverseReadFromColumn(int[][] matrix) {
        int row = 0, col = 0;
        int colPtr = matrix.length - 1;

        while (row < matrix.length) {
            int colPtri = colPtr;
            col = 0;
            while (col < colPtri) {
                int swap = matrix[row][col];
                matrix[row][col] = matrix[row][colPtri];
                matrix[row][colPtri] = swap;
                colPtri--;
                col++;
            }
            row++;
        }
    }
}
