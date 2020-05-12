package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {

    public static void main(String[] args) {
        combine(4,2);
        System.out.println(1);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        helper(combinations,new ArrayList<>(),1,n,k);
        return combinations;
    }

    private static void helper(List<List<Integer>> combinations, List<Integer> combination, int start, int n, int k) {
        if(k==0)
        {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for(int i = start ; i <= (n-k+1) ; i++)
        {
            combination.add(i);
            helper(combinations,combination,i+1,n,k-1);
            combination.remove(combination.size()-1);
        }
    }
}


