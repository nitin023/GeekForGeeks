package LeetCode.Easy.Tree;

import java.util.Map;

public class ConstructTreeFromInorderAndPostorder {

    private static TreeNode constructFromInorderAndPostorder(int start, int end, int[] postorder, Integer pIndex, Map<Integer, Integer> inorderKeyMap) {
        //base case
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[pIndex--]);

        if (start == end) {
            return node;
        }

        int index = inorderKeyMap.get(node.val);

        node.right = constructFromInorderAndPostorder(index + 1, end, postorder, pIndex, inorderKeyMap);
        node.left = constructFromInorderAndPostorder(start, index - 1, postorder, pIndex, inorderKeyMap);

        return node;
    }
}
