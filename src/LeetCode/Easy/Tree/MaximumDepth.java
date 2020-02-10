package LeetCode.Easy.Tree;

public class MaximumDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(12);

        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null)
        {
            return depth;
        }

        int leftMaxDepth = maxDepth(root.left) + 1;
        int rightMaxDepth = maxDepth(root.right) + 1;
        return Math.max(leftMaxDepth , rightMaxDepth);
    }
}
