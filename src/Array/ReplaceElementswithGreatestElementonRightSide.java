package Array;

/**
 * Replace Elements with Greatest Element on Right Side
 * Given an array arr, replace every element in that array with the greatest element
 * among the elements to its right, and replace the last element with -1.
 * <p>
 * After doing so, return the array.
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 */

public class ReplaceElementswithGreatestElementonRightSide {

    public static void main(String[] args) {
        replaceElements(new int[]{17,18,5,4,6,1});
    }
    public static int[] replaceElements(int[] arr) {

        if (arr == null || arr.length == 0) {
            return arr;
        }

        int max = -1;
        for (int i = arr.length - 1 ; i >=0 ; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp,max);
        }
        return arr;
    }


}
