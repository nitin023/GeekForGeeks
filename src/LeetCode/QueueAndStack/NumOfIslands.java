package LeetCode.QueueAndStack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

public class NumOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int i, j;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands += dfsIterative(grid, i, j, grid.length, grid[i].length);
                }
            }
        }
        return numIslands;
    }

    private static int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

        return 1;
    }

    private static int dfsIterative(char[][] grid, int indexI, int indexJ, int row, int col) {
        if (grid == null) {
            return 0;
        }

        Stack<String> stack = new Stack<>();
        stack.push(indexI + "-" + indexJ);

        Set<String> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int k = 0; k < size; k++) {
                String indices = stack.pop();
                int x = Integer.parseInt(indices.split("-")[0]);
                int y = Integer.parseInt(indices.split("-")[1]);
                if (!visited.contains(indices)) {
                    visited.add(indices);
                    if (x + 1 < row && grid[x + 1][y] !='0') {
                        grid[x + 1][y] = '0';
                        stack.add((x + 1) + "-" + y);
                    }
                    if (x - 1 >= 0 && x - 1 < row  && grid[x - 1][y] !='0') {
                        grid[x - 1][y] = '0';
                        stack.add((x - 1) + "-" + y);
                    }
                    if (y + 1 < col  && grid[x][y+1] !='0') {
                        grid[x][y + 1] = '0';
                        stack.add(x + "-" + (y + 1));
                    }
                    if (y - 1 >= 0 && y - 1 < col && grid[x][y-1] !='0') {
                        grid[x][y - 1] = '0';
                        stack.add(x + "-" + (y - 1));
                    }
                }
            }
        }
        return 1;
    }
}
