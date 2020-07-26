package GeekForGeeks.Amazon;

/**
 * https://practice.geeksforgeeks.org/problems/binary-array-sorting5355/1
 */
public class SortZeroOne {
    public int[] SortBinaryArray(int[] arr, int n) {
        // code here
        if (arr == null || n == 0) {
            return arr;
        }

        int numOnes = 0, numZeroes = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                numZeroes++;
            } else {
                numOnes++;
            }
        }

        int index = 0;
        while (numZeroes > 0) {
            arr[index++] = 0;
            numZeroes--;
        }

        while (numOnes > 0) {
            arr[index++] = 1;
            numOnes--;
        }
        return arr;
    }
}
