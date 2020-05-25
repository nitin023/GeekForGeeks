package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Duplicate Zeros
 * Given a fixed length array arr of integers, duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 */
public class DuplicateZeros {

    public static void main(String[] args) {
        duplicateZeros(new int[]{0  , 0 , 0 , 0 , 0});
        System.out.println(1);
    }
    public void duplicateZerosWithExtraSpace(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        List<Integer> resultTantList = new ArrayList<>();

        for(int item : arr)
        {
            if(item == 0)
            {
                resultTantList.add(0);
                resultTantList.add(0);
            }
            else
            {
                resultTantList.add(item);
            }
        }

        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = resultTantList.get(i);
        }
    }

    public static void duplicateZeros(int[] arr) {

        for(int i = 0 ; i < arr.length ; )
        {
            if(arr[i]==0 && i+1 < arr.length)
            {
                int secondLastInd = arr.length - 2;
                while (secondLastInd > i)
                {
                    arr[secondLastInd+1] = arr[secondLastInd];
                    secondLastInd--;
                }
                arr[i+1] = 0;
                i+=2;
            }
            else
            {
                i++;
            }
        }
    }
}
