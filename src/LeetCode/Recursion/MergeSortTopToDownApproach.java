package LeetCode.Recursion;

public class MergeSortTopToDownApproach {

    public static void main(String[] args) {
        int []nums = {4,3,2,12,1};
        nums = sortArray(nums);
        System.out.println(1);
    }

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }

    private static void mergeSort(int low, int high, int[] nums) {

        int[] temp = new int[nums.length];
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid, nums);
            mergeSort(mid + 1, high, nums);
            merge(nums, temp, low, mid, mid + 1, high);
            copy(nums,temp,low,high);
        }
    }

    private static void merge(int[] nums, int[] temp, int low1, int high1, int low2, int high2) {
        int i = low1, j = low2, k = low1;
        while (i <= high1 && j <= high2) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= high1) {
            temp[k++] = nums[i++];
        }
        while (j <= high2) {
            temp[k++] = nums[j++];
        }
    }

    private static void copy(int[] nums, int[] temp, int low, int high) {
        while (low <= high) {
            nums[low] = temp[low];
            ++low;
        }
    }

}
