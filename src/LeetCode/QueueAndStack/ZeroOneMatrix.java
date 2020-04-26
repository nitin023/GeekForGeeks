package LeetCode.QueueAndStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
