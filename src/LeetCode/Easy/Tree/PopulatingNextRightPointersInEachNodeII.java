package LeetCode.Easy.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node II
 * <p>
 * Given a binary tree
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
 * <p>
 * <p>
 * Follow up:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(7);
        System.out.println(connectWithExtraSpace(root));
    }

    public static Node connectWithExtraSpace(Node root) {
        if (root == null) {
            return null;
        }

        Queue queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelNodeCnt = queue.size();
            List<Node> levelOrderList = new ArrayList<>();

            while (levelNodeCnt > 0) {
                Node currentNode = (Node) queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                levelOrderList.add(currentNode);
                levelNodeCnt--;
            }

            for (int i = 0; i + 1 < levelOrderList.size(); i++) {
                levelOrderList.get(i).next = levelOrderList.get(i + 1);
            }
        }
        return root;
    }
}
