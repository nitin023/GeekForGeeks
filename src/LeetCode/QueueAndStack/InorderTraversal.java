package LeetCode.QueueAndStack;

import LeetCode.Easy.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTraversalList = new ArrayList<>();

        if (root == null) {
            return inorderTraversalList;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode tempNode = stack.pop();
                inorderTraversalList.add(tempNode.val);
                currentNode = tempNode.right;
            }
        }
        return inorderTraversalList;
    }
}
