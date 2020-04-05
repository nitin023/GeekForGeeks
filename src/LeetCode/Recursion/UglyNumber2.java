package LeetCode.Recursion;

import LeetCode.Easy.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber2 {

    public static void main(String[] args) {

        List<TreeNode> totalTreesFrom1toN = constructTrees(1, 2);
    }

    static ArrayList<TreeNode> constructTrees(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        /*  if start > end   then subtree will be empty so returning NULL
            in the list */
        if (start > end) {
            list.add(null);
            return list;
        }

        /*  iterating through all values from start to end  for constructing\
            left and right subtree recursively  */
        for (int i = start; i <= end; i++) {
            /*  constructing left subtree   */
            ArrayList<TreeNode> leftSubtree = constructTrees(start, i - 1);

            /*  constructing right subtree  */
            ArrayList<TreeNode> rightSubtree = constructTrees(i + 1, end);

            /*  now looping through all left and right subtrees and connecting
                them to ith root  below  */
            for (TreeNode left : leftSubtree) {
                for (TreeNode right : rightSubtree) {
                    TreeNode node = new TreeNode(i);        // making value i as root
                    node.left = left;              // connect left subtree
                    node.right = right;            // connect right subtree
                    list.add(node);                // add this tree to list
                }
            }
        }
        return list;
    }

}
