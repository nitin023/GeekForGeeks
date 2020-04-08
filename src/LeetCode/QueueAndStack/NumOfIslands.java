package LeetCode.QueueAndStack;

/**
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

public class NumOfIslands {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0)
        {
            return 0;
        }

        int numIslands = 0 ;
        int i , j;

        for( i = 0 ; i<grid.length ; i++)
        {
            for(j = 0 ; j < grid[i].length ; j++)
            {
                if(grid[i][j] == '1')
                {
                    numIslands+=dfs(grid,i,j);
                }
            }
        }
        return numIslands;
    }

    private static int dfs(char [][]grid , int i , int j)
    {
        if(i<0  || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0')
        {
            return 0;
        }

        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

        return 1;
    }

}
