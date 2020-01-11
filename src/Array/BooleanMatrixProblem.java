package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is r and c, r is the number of rows and c is the number of columns.
 * The second line of each test case contains all the elements of the matrix in a single line separated by a single space.
 *
 * Output:
 * Print the modified array.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ r, c ≤ 1000
 * 0 ≤ A[i][j] ≤ 1
 *
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
 *
 * Output:
 * 1 1
 * 1 0
 * 0 0 1
 * 1 1 1
 * 1 1 1
 * 1 1 1
 * 1 0 0
 *
 * Explanation:
 * Testcase1: Since only first element of matrix has 1 (at index 1,1) as value, so first row and first column are modified to 1.
 *
 */
public class BooleanMatrixProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = 0;

            testCases = Integer.parseInt(br.readLine());


        while (testCases > 0)
        {
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int row = Integer.parseInt(strs[0]);
            int col = Integer.parseInt(strs[1]);

            int i , j;
            int [][] booleanMatrix = new int[row][col];

            Set<Integer> rowsToOne = new HashSet<>();
            Set<Integer> colToOne = new HashSet<>();
            for(i = 0 ; i < row ; i++)
            {
                line = br.readLine();
                strs = line.trim().split("\\s+");
                for(j = 0 ; j < strs.length ; j++)
                {
                    booleanMatrix[i][j] = Integer.parseInt(strs[j]);
                    if(booleanMatrix[i][j] == 1)
                    {
                        rowsToOne.add(i);
                        colToOne.add(j);
                    }
                }
            }


            StringBuilder stringBuilder = new StringBuilder();
            for(i = 0 ; i < row ; i++)
            {
                for(j = 0 ; j < col ; j++)
                {
                   if(rowsToOne.contains(i) || colToOne.contains(j))
                   {
                       booleanMatrix[i][j] = 1;
                   }
                    stringBuilder.append(booleanMatrix[i][j]).append(" ");
                }
                stringBuilder.append("\n");
            }

            System.out.println(stringBuilder);
            testCases --;
        }
    }
}
