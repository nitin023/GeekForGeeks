package Array;

/**
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 */
public class SquareSortedArray {

    public static void main(String[] args) {
        int[] k = sortedSquares(new int[]{-4,0});
    }

    /**
     * Solved by breaking the array into two sub-arrays
     * by identifying negative to positive transition
     * and then simply using merging of two sorted
     * subarrays logic for solving the problem
     * @param A array
     * @return int array
     */
    public static int[] sortedSquares(int[] A) {
        int negativeInd = isNegativeIndexExist(A);
        if(negativeInd >= 0)
        {
            int firstPtr = negativeInd;
            int secondPtr = firstPtr+1;

            int []mergedArray = new int[A.length];
            int k = 0;

            while (firstPtr >= 0 && secondPtr < A.length)
            {
                int sqrFirstPtr = A[firstPtr] * A[firstPtr];
                int sqrSecondPtr = A[secondPtr] * A[secondPtr];

                if(sqrFirstPtr < sqrSecondPtr)
                {
                    mergedArray[k++] = sqrFirstPtr;
                    firstPtr--;
                }
                else if(sqrFirstPtr == sqrSecondPtr) {
                    secondPtr++;
                    firstPtr--;
                    mergedArray[k++] = sqrFirstPtr;
                    mergedArray[k++] = sqrFirstPtr;
                }
                else
                {
                    mergedArray[k++] = sqrSecondPtr;
                    secondPtr++;
                }
            }
            while (firstPtr >= 0)
            {
                mergedArray[k++] = A[firstPtr] * A[firstPtr];
                firstPtr--;
            }
            while (secondPtr < A.length)
            {
                mergedArray[k++] = A[secondPtr] * A[secondPtr];
                secondPtr++;
            }
            return mergedArray;
        }
        else
        {
            for(int i = 0 ; i < A.length ; i++)
            {
                A[i] = A[i] * A[i];
            }
            return A;
        }
    }

    private static int isNegativeIndexExist(int []A)
    {
        for(int i = 0 ; i < A.length ; i++)
        {
            if(A[i] < 0 &&  i+1 < A.length && A[i+1] >= 0)
            {
                return i;
            }
        }

        return -1;
    }
}
