package Array;

import sun.awt.X11.XWMHints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is r and c, r is the number of rows and c is the number of columns.
 * The second line of each test case contains all the elements of the matrix in a single line separated by a single space.
 * <p>
 * Output:
 * Print the modified array.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ r, c ≤ 1000
 * 0 ≤ A[i][j] ≤ 1
 * <p>
 * Example:
 * Input:
 * 3
 * 2 2
 * 1 0
 * 0 0
 * 2 3
 * 0 0 0
 * 0 0 1
 * 4 3
 * 1 0 0
 * 1 0 0
 * 1 0 0
 * 0 0 0
 * <p>
 * Output:
 * 1 1
 * 1 0
 * 0 0 1
 * 1 1 1
 * 1 1 1
 * 1 1 1
 * 1 0 0
 * <p>
 * Explanation:
 * Testcase1: Since only first element of matrix has 1 (at index 1,1) as value, so first row and first column are modified to 1.
 */
public class BooleanMatrixProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            int i, j;
            int[][] booleanMatrix = new int[row][col];

            Set<Integer> rowsToOne = new HashSet<>();
            Set<Integer> colToOne = new HashSet<>();
            for (i = 0; i < row; i++) {
                j = 0;
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreElements()) {
                    booleanMatrix[i][j] = Integer.parseInt(st.nextToken());
                    if (booleanMatrix[i][j] == 1) {
                        rowsToOne.add(i);
                        colToOne.add(j);
                    }
                    j++;
                }
            }


            StringBuilder stringBuilder = new StringBuilder();
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    if (rowsToOne.contains(i) || colToOne.contains(j)) {
                        booleanMatrix[i][j] = 1;
                    }
                    stringBuilder.append(booleanMatrix[i][j]).append(" ");
                }
                stringBuilder.append("\n");
            }

            System.out.println(stringBuilder);
            testCases--;
        }
    }
}
