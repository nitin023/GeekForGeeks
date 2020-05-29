package Array.BinarySearch;


/**
 * Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example :
 * <p>
 * Input: n = 10, pick = 6
 * Output: 6
 */
public class GuessNumberHigherOrLower {

    public int getGuessedNumberUsingBinarySearch(int n) {

        long low = 1, high = n;

        while (low <= high) {
            long mid = (low + high) / 2;
            int apiResponse = guess((int) mid);
            if (apiResponse == 0) {
                return (int) mid;
            } else if (apiResponse == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return num - 1;
    }

    /**
     * Ternary Search
     * In Binary Search, we choose the middle element as the pivot in splitting.
     * In Ternary Search, we choose two pivots (say m1 and m2) such that the given range is divided into three equal parts.
     * If the required number numnum is less than m1m1 then we apply ternary search on the left segment of m1.
     * If num lies between m1 and m2, we apply ternary search between m1m1 and m2m2.
     * Otherwise we will search in the segment right to m2.
     */
    public int guessNumberUsingTernarySearch(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }

    /**
     * Complexity Analysis
     *
     * Time complexity : O(log_3n)
     * Space complexity : O(1). No extra space is used.
     * Comparisons between Binary Search and Ternary Search
     * Ternary Search does more comparisons than Binary Search in the worst case.
     */

}
