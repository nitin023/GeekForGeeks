package LeetCode.Easy.Tree;

import java.util.HashSet;
import java.util.Set;

public class PathSum {

    public static void main(String[] args) {
        hasPathSum(null,5);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        Set<Integer> allSums = new HashSet<>();
        getSum(root, new int[1000], 0, allSums);
        return allSums.contains(sum);
    }

    private static void getSum(TreeNode node, int[] path, int index, Set<Integer> allSums) {

        if (node == null) {
            return;
        }

        path[index] = node.val;

        if (node.left == null && node.right == null) {
            int tempSum = 0;
            for (int i = 0; i <= index; i++) {
                tempSum += path[i];
            }
            allSums.add(tempSum);
        }

        getSum(node.left, path, index + 1, allSums);
        getSum(node.right, path, index + 1, allSums);
    }
}
