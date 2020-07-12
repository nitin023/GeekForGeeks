package com.twelve.weeks.course.week1.Medium;

import LeetCode.Easy.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * <p>
 * Calling next() will return the next smallest number in the BST.
 *
 * Solved by iterating using in-order traversal of BST
 * and using that sorted order to form a stack of sorted values
 * and pop-ing up stack elements to find the smallest elements
 */
public class BSTIterator {

    private Stack<Integer> bstInorderTraversal;

    public BSTIterator(TreeNode root) {
        this.bstInorderTraversal = new Stack();
        getInorderTraversal(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return bstInorderTraversal.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !bstInorderTraversal.isEmpty();
    }

    private void getInorderTraversal(TreeNode root) {
        List<Integer> sortedList = new ArrayList();

        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                sortedList.add(root.val);
                root = root.right;
            }
        }

        for (int i = sortedList.size() - 1; i >= 0; i--) {
            bstInorderTraversal.push(sortedList.get(i));
        }
    }
}

