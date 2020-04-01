package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public static void main(String[] args) {

        System.out.println(getRow(5));
    }

    public static List<Integer> getRow(int rowIndex) {

        if (rowIndex < 0)
        {
            return null;
        }
        List<Integer>rowElements = new ArrayList<>();

        int[][] arr = new int[20][20];
        for(int i = 1 ; i <= rowIndex+1 ; i++)
        {
           rowElements.add(getPascalTriangle(rowIndex+1,i,rowIndex+1,arr));
        }
        return rowElements;
    }

    public static int getPascalTriangle(int i , int j ,int levels , int[][] arr)
    {
        if(i == 1 || j == 1 || i == j)
        {
            if(arr[i][j] == 0){
                arr[i][j] = 1;
            }
            return 1;
        }

        if(arr[i][j] == 0){
        arr[i][j] = getPascalTriangle(i-1,j,levels-1,arr) + getPascalTriangle(i-1,j-1,levels-1,arr);
        }

        return arr[i][j];
    }
}
