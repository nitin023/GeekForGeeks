package LeetCode.Easy.Tree;

public class ConvertSortedArrToBST {

    public static void main(String[] args) {
        int []nums = {-1,3,5,6,8,9};
        sortedArrayToBST(nums);
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
        {
            return null;
        }

        return getBST(nums,0,nums.length-1);
    }

    private static TreeNode getBST(int arr[] ,int start , int end)
    {
        if(start > end)
        {
            return null;
        }

        int mid = (start + end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = getBST(arr,start,mid-1);
        node.right = getBST(arr,mid+1 , end);
        return node;
    }
}
