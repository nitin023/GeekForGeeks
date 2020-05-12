package LeetCode.Recursion;

import LeetCode.Easy.Tree.TreeNode;

/**
 * Two trees are called same iff they are structurally same
 *
 * Problem can be solved using recursion and iteration
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return helperRecursive(p,q);
    }

    private boolean helperRecursive(TreeNode p, TreeNode q)
    {

        if(p == null && q == null)
        {
            return true;
        }
        if(p==null || q==null)
        {
            return false;
        }
        if(p.val != q.val)
        {
            return false;
        }
        return helperRecursive(p.left,q.left) && helperRecursive(p.right , q.right);
    }
}
