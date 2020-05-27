package Array.BinarySearch;

/**
 * Sqrt(x)
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {

        long low = 1;
        long high = x / 2;
        long mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid == x) {
                return  (int)mid;
            } else if (mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (mid * mid <= x) {
            return (int)mid;
        } else {
            return (int)mid - 1;
        }
    }
}
