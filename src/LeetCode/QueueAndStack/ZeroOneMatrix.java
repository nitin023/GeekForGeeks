package LeetCode.QueueAndStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.min;

/**
 * 01 Matrix
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * Example 1:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Example 2:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class ZeroOneMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

        matrix = updateMatrix(matrix);
        System.out.println(1);
    }

    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        Map<Integer, List<Integer>> zeroIndexListMap = new HashMap<>();
        Map<Integer, List<Integer>> oneIndexListMap = new HashMap<>();
        Map<Integer, List<Integer>> zeroIndexColMap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int elem = matrix[i][j];
                if (elem == 0) {
                    if (!zeroIndexListMap.containsKey(i)) {
                        zeroIndexListMap.put(i, new ArrayList<>());
                    }
                    zeroIndexListMap.get(i).add(j);
                    if (!zeroIndexColMap.containsKey(j)) {
                        zeroIndexColMap.put(j, new ArrayList<>());
                    }
                    zeroIndexColMap.get(j).add(i);
                } else {
                    if (!oneIndexListMap.containsKey(i)) {
                        oneIndexListMap.put(i, new ArrayList<>());
                    }
                    oneIndexListMap.get(i).add(j);
                }
            }
        }

        for (int row : oneIndexListMap.keySet()) {
            List<Integer> oneList = oneIndexListMap.get(row);
            int minDistanceInRow, minDistanceInCol;
            for (int col : oneList) {
                int currentRowMin = getMinInRow(zeroIndexListMap, row, col, 0);
                int prevRowMin = getMinInRow(zeroIndexListMap, row - 1, col, 1);
                int nextRowMin = getMinInRow(zeroIndexListMap, row + 1, col, 1);

                minDistanceInRow = Math.min(prevRowMin, nextRowMin);
                minDistanceInRow = Math.min(minDistanceInRow, currentRowMin);

                int currentColMin = getMinInCol(zeroIndexColMap, row, col, 0);
                int leftColMin = getMinInCol(zeroIndexColMap, row, col - 1, 1);
                int rightColMin = getMinInCol(zeroIndexColMap, row, col + 1, 1);

                minDistanceInCol = Math.min(leftColMin, rightColMin);
                minDistanceInCol = Math.min(minDistanceInCol, currentColMin);
                matrix[row][col] = Math.min(minDistanceInRow, minDistanceInCol);
            }


        }
        return matrix;
    }

    private static int getMinInRow(Map<Integer, List<Integer>> zeroIndexListMap, int row, int col, int additiveFact) {
        int minAsPerRow = Integer.MAX_VALUE;

        if (zeroIndexListMap.containsKey(row)) {
            List<Integer> zeroList = zeroIndexListMap.get(row);
            for (int zeroInd : zeroList) {
                int val = Math.abs(zeroInd - col) + additiveFact;
                if (minAsPerRow > val) {
                    minAsPerRow = val;
                }
            }
        }
        return minAsPerRow;
    }

    private static int getMinInCol(Map<Integer, List<Integer>> zeroIndexListMapInCol, int row, int col, int additiveFact) {
        int minAsPerRow = Integer.MAX_VALUE;

        if (zeroIndexListMapInCol.containsKey(col)) {
            List<Integer> zeroList = zeroIndexListMapInCol.get(col);
            for (int zeroInd : zeroList) {
                int val = Math.abs(zeroInd - row) + additiveFact;
                if (minAsPerRow > val) {
                    minAsPerRow = val;
                }
            }
        }
        return minAsPerRow;
    }

    /**
     * DP Approach
     * <p>
     * Approach #3 DP Approach [Accepted]
     * Intuition
     * <p>
     * The distance of a cell from 0 can be calculated if we know the nearest distance for all the neighbours,
     * in which case the distance is minimum distance of any neightbour + 1. And, instantly, the word come to mind DP!!
     * For each 1, the minimum path to 0 can be in any direction.
     * So, we need to check all the 4 direction.
     * In one iteration from top to bottom, we can check left and top directions, and we need another iteration from bottom to top to check for right and bottom direction.
     * <p>
     * Algorithm
     * <p>
     * Iterate the matrix from top to bottom-left to right:
     * Update \text{dist}[i][j]=\min(\text{dist}[i][j],\min(\text{dist}[i][j-1],\text{dist}[i-1][j])+1)dist[i][j]=min(dist[i][j],min(dist[i][j−1],dist[i−1][j])+1)
     * i.e., minimum of the current dist and distance from top or left neighbour +1,
     * that would have been already calculated previously in the current iteration.
     * Now, we need to do the back iteration in the similar manner: from bottom to top-right to left:
     * Update \text{dist}[i][j]=\min(\text{dist}[i][j],\min(\text{dist}[i][j+1],\text{dist}[i+1][j])+1)dist[i][j]=min(dist[i][j],min(dist[i][j+1],dist[i+1][j])+1) i.e. minimum of current dist and distances calculated from bottom and right neighbours, that would be already available in current iteration.
     */
    public static int[][] updateMatrixDP(int[][] matrix) {
        int[][] dist = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    if (i > 0)
                        dist[i][j] = min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        //Second pass: check for bottom and right
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (i < matrix.length - 1)
                    dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1);
                if (j < matrix[i].length - 1)
                    dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1);
            }
        }

        return dist;
    }
}
