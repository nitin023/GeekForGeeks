package LeetCode.Easy.Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.left.left = new TreeNode(5);

        getLevelOrderTraversal(treeNode);
    }

    private static void getLevelOrderTraversal(TreeNode root) {

        List<List<Integer>> levelOrderTraversal = new ArrayList<>();

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int nodeCount =  0;

        queue.add(root);

        while (!queue.isEmpty())
        {
            nodeCount = queue.size();

            List<Integer> levelOrderList = new ArrayList<>();

            while (nodeCount > 0)
            {
                TreeNode treeNode = queue.peek();

                levelOrderList.add(treeNode.val);

                if(treeNode.left != null)
                {
                    queue.add(treeNode.left);
                }

                if(treeNode.right != null)
                {
                    queue.add(treeNode.right);
                }

                queue.remove();

                nodeCount --;
            }

            levelOrderTraversal.add(levelOrderList);
        }
    }
}
