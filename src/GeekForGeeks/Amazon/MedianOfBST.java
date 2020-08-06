package GeekForGeeks.Amazon;


import LeetCode.Easy.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/median-of-bst/1
 *
 * problem is simple just find the inorder traversal and then find the median
 */
public class MedianOfBST {

    public static void findMedian(TreeNode root) {
        // code here.

        List<Integer> list = new ArrayList();

        getInorderTraversal(root, list);
        double response;

        int mid = list.size() / 2;
        if (list.size() % 2 != 0) {
            response = list.get(mid);
        } else {
            response = (list.get(mid) + list.get(mid - 1)) / 2;
        }
        System.out.println(response);
    }

    private static void getInorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getInorderTraversal(root.left, list);

        list.add(root.val);

        getInorderTraversal(root.right, list);
    }
}
