package LeetCode.Easy.Tree;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class constructTreeFromInorderAndPreorder {

    private  TreeNode constructFromInorderAndPreorder(int start, int end, int[] preorder, AtomicInteger pIndex, Map<Integer, Integer> inorderKeyMap) {

        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pIndex.getAndIncrement()]);

        if (start == end) {
            return node;
        }

        int index = inorderKeyMap.get(node.val);

        node.left = constructFromInorderAndPreorder(start, index - 1, preorder, pIndex, inorderKeyMap);

        node.right = constructFromInorderAndPreorder(index + 1, end, preorder, pIndex, inorderKeyMap);

        return node;
    }
}
