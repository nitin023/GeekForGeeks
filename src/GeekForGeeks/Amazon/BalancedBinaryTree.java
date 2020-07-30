package GeekForGeeks.Amazon;

import LeetCode.Easy.Tree.TreeNode;

/**
 * 110. Balanced Binary Tree
 * Easy
 * https://leetcode.com/problems/balanced-binary-tree/
 * https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
 * <p>
 * problem solves by just tweaking the getHeight logic
 * during finding height of a sub-tree
 * we always comes across a height og left subtree and right subtree
 * so on taking difference if we found that height > 1 than height balancing is disturbed
 * and even a empty tree has height balancing as height of left and right subtrees = 0
 */
public class BalancedBinaryTree {

    boolean result = true;

    public boolean isBalanced(TreeNode root) {

        getTreeHeight(root);
        return result;
    }


    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getTreeHeight(root.left) + 1;
        int right = getTreeHeight(root.right) + 1;

        if (Math.abs(left - right) > 1) {
            result = false;
        }

        return Math.max(left, right);
    }
}
