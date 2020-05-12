package LeetCode.Recursion;

import LeetCode.Easy.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Two trees are called same iff they are structurally same
 * <p>
 * Problem can be solved using recursion and iteration
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return helperIteratively(p, q);
    }

    private boolean helperRecursive(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return helperRecursive(p.left, q.left) && helperRecursive(p.right, q.right);
    }

    private boolean checkIfNodeAreSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val;
    }

    private boolean helperIteratively(TreeNode p, TreeNode q) {
        return levelOrderTraversal(p).equals(levelOrderTraversal(q));
    }

    private String levelOrderTraversal(TreeNode tree) {
        if (tree == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                sb.append("N");
            } else {
                sb.append(currentNode.val);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return sb.toString();
    }
}
