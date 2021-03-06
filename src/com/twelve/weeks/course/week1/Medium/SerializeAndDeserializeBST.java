package com.twelve.weeks.course.week1.Medium;

import LeetCode.Easy.Tree.TreeNode;

import java.util.*;

/**
 * 449. Serialize and Deserialize BST
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string and this string can be de-serialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 * <p>
 * Approach is to convert BST into a serialized string using preorder traversal and separating each node value with binary counterpart
 * and also adding a separator between them
 * Upon de-serializing this string is split using separator string and list so obtained being in pre-order traversal helps
 * to convert values to a BST
 */
public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return null;
        }
        return getSerializedString(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] seperatedStr = data.split("-");
        return getTreeFromInorderTraversal(seperatedStr);
    }

    private String getSerializedString(TreeNode root) {
        List<Integer> preOrderTraversal = getPreOrderIterativeTraversal(root);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < preOrderTraversal.size(); i++) {
            int value = preOrderTraversal.get(i);
            builder.append(Integer.toBinaryString(value));
            if (i < preOrderTraversal.size() - 1) {
                builder.append("-");
            }
        }
        return builder.toString();
    }

    public static List<Integer> getPreOrderIterativeTraversal(TreeNode node) {
        List<Integer> preorderList = new ArrayList();

        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                preorderList.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return preorderList;
    }

    private TreeNode getTreeFromInorderTraversal(String[] separatedStr) {
        return bstFromPreOrder(separatedStr);
    }

    public static TreeNode bstFromPreOrder(String[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        Queue<String> preOrderQueue = new LinkedList<>(Arrays.asList(preorder));
        return insertIntoBST(preOrderQueue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode insertIntoBST(Queue<String> preOrderQueue, int lower, int upper) {
        if (preOrderQueue.isEmpty()) return null;
        int value = Integer.parseInt(preOrderQueue.peek(), 2);
        if (value < lower || value > upper) return null;
        preOrderQueue.poll();
        TreeNode node = new TreeNode(value);
        node.left = insertIntoBST(preOrderQueue, lower, value);
        node.right = insertIntoBST(preOrderQueue, value, upper);
        return node;
    }
}
