package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
 * <p>
 * For Example:
 * If the matrix is
 * <p>
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * The output should Return the following :
 * <p>
 * [
 * [1],
 * [2, 4],
 * [3, 5, 7],
 * [6, 8],
 * [9]
 * ]
 * i.e print the elements of array diagonally.
 * <p>
 * Note: The input array given is in single line and you have to output the answer in one line only.
 * <p>
 * <p>
 * <p>
 * Input:
 * <p>
 * The first line contains an integer T, depicting total number of test cases.
 * Then following T lines contains an integer N depicting the size of square matrix and next line followed by the value of array.
 * <p>
 * <p>
 * Output:
 * <p>
 * Print the elements of matrix diagonally in separate line.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 ≤ T ≤ 30
 * 1 ≤ N ≤ 20
 * 0 ≤ A[i][j] ≤ 9
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * 2
 * 2
 * 1 2 3 4
 * 3
 * 1 2 3 4 5 6 7 8 9
 * Output:
 * 1 2 3 4
 * 1 2 4 3 5 7 6 8 9
 */
public class PrintDiagonally {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[numElem][numElem];
            int i, j;

            st = new StringTokenizer(br.readLine());
            for (i = 0; i < numElem; i++) {
                for (j = 0; j < numElem; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            getDiagonalPrint(matrix,numElem);
            testCases--;
        }
    }

    /**
     * This simply reduces to find the sum of indexes
     * if indexes sum = 1 , 2 , 3 ...n
     * then we can print diagonal elements
     * @param matrix
     * @param numElem
     */
    private static void getDiagonalPrint(int [][]matrix , int numElem)
    {
        Map<Integer,List<Integer>> indexSumMap = new HashMap<>();
        List<Integer> sumList = new ArrayList<>();
        List<Integer> tList;
        for(int i = 0 ; i < numElem ; i++)
        {
            for(int j = 0 ; j < numElem ; j++)
            {
                tList = new ArrayList<>();
                if(indexSumMap.containsKey(i+j))
                {
                    tList = indexSumMap.get(i+j);
                    tList.add(matrix[i][j]);
                }
                else
                {
                    tList.add(matrix[i][j]);
                    sumList.add((i+j));
                }
                indexSumMap.put((i+j),tList);
            }
        }

        StringBuilder finalResult = new StringBuilder();
        for (Integer integer : sumList) {
            tList = indexSumMap.get(integer);
            for(int item : tList) {
                finalResult.append(item).append(" ");
            }
        }
        System.out.println(finalResult);
    }
}
