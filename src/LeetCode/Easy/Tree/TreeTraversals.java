package LeetCode.Easy.Tree;

import java.util.*;

public class TreeTraversals {

    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<Integer> responses = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {

            if (node != null) {
                responses.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }

        return responses;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> responses = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                responses.add(root.val);
                root = root.right;
            }
        }

        return responses;
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> responses = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (root != null || !stack1.isEmpty()) {
            if (root != null) {
                stack2.push(root);
                stack1.push(root);
                root = root.right;
            } else {
                root = stack1.pop();
                root = root.left;
            }
        }

        while (!stack2.isEmpty()) {

            responses.add(stack2.pop().val);
        }
        return responses;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelOrderTraversal = new ArrayList<>();

        if (root == null) {
            return levelOrderTraversal;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Queue<TreeNode> levelQueue;

        while (!queue.isEmpty()) {

            levelQueue = new LinkedList<>(queue);

            List<Integer> levelTraversal = new ArrayList<>();

            while (!levelQueue.isEmpty()) {
                TreeNode node = levelQueue.remove();

                levelTraversal.add(node.val);

                TreeNode currentQueueNode = queue.remove();

                if (currentQueueNode.left != null) {
                    queue.add(currentQueueNode.left);
                }

                if (currentQueueNode.right != null) {
                    queue.add(currentQueueNode.right);
                }

            }

            levelOrderTraversal.add(levelTraversal);
        }

        return levelOrderTraversal;
    }
}
