package LeetCode.Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * DYNAMIC PROGRAMMING
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class ClimbLadders {

    public static void main(String[] args) {

        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {

        Map<Integer,Integer> stairNumWaysMap = new HashMap<>();
        return getClimbingStairsWays(n,stairNumWaysMap);
    }

    private static int getClimbingStairsWays(int n , Map<Integer,Integer> stairNumWaysMap)
    {
        if(stairNumWaysMap.containsKey(n))
        {
            return stairNumWaysMap.get(n);
        }

        if(n >=1 && n<=2)
        {
            return n;
        }

        else
        {
            int response =  getClimbingStairsWays(n-1 ,stairNumWaysMap) + getClimbingStairsWays(n-2 , stairNumWaysMap);
            stairNumWaysMap.put(n,response);
            return response;
        }
    }

    //o(n) time and space
    private static int getClimbingStairsUsingDP(int n)
    {
        if(n==1)
        {
            return 1;
        }

        int []dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i<=n ; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //logn pow
    public int climbStairsFibFormula(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
}
