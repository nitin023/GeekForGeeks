package LeetCode.Easy.Tree;

import java.util.*;

/**
 * Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Follow up:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 */

public class PopulatingNextRightPointerInNode {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(7);

        root = builtNextForCompleteNodeTree(root);

    }

    private static Node builtNextForCompleteNodeTree(Node node)
    {
        if(node == null || node.left ==null)
        {
            return node;
        }

        node.left.next = node.right;

        Node left = node.left;
        Node right = node.right;

        while (left.right !=null && right.left !=null)
        {
            left = left.right;
            right = right.left;
            left.next = right;
        }

        builtNextForCompleteNodeTree(node.left);
        builtNextForCompleteNodeTree(node.right);
        return node;
    }

}


