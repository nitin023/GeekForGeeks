package LeetCode.Easy.Tree;

public class CheckWhetherTreeIsMirrorOfSelf {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(3);

        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        StringBuilder lrInorder = new StringBuilder();
        getInorderLR(root,lrInorder);

        StringBuilder rlInorder = new StringBuilder();
        getInorderRL(root,rlInorder);

        return rlInorder.toString().equals(lrInorder.toString());
    }

    private static void getInorderLR(TreeNode node,StringBuilder lrInorder)
    {
        if(node == null)
        {
            lrInorder.append("N");
            return;
        }
        lrInorder.append(node.val);
        getInorderLR(node.left,lrInorder);
        getInorderLR(node.right,lrInorder);
    }

    private static void getInorderRL(TreeNode node,StringBuilder rlInorder)
    {
        if(node == null)
        {
            rlInorder.append("N");
            return;
        }
        rlInorder.append(node.val);
        getInorderRL(node.right,rlInorder);
        getInorderRL(node.left,rlInorder);
    }
}
