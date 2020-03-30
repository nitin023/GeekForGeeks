package LeetCode.Recursion;

import LeetCode.Easy.Tree.TreeNode;

public class SearchInBST {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right = new TreeNode(7);
        TreeNode root =  searchBST(node,3);
        System.out.println(1);
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        if(root == null)
        {
            return null;
        }

        return search( root ,  val);
    }

    private static TreeNode searchInBST(TreeNode root , int val)
    {
        while (root !=null && val != root.val)
        {
            if(root.val < val)
            {
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }
        return root;
    }

    private static TreeNode searchRecursively(TreeNode root , int val)
    {
        if(root.val == val)
        {
            return root;
        }
        if(root.val < val)
        {
            root = root.right;
        }
        else
        {
            root = root.left;
        }
        return searchRecursively(root,val);
    }
}
