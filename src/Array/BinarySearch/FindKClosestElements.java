package Array.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find K Closest Elements
 * Given a sorted array arr, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order.
 * If there is a tie, the smaller elements are always preferred.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * Constraints:
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 10^4
 * Absolute value of elements in the array and x will not exceed 104
 */
public class FindKClosestElements {

    public static void main(String[] args) {
        findClosestElements(new int[]{1,10,15,25,35,45,50,59},
                1,
                30
        );
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - 1, mid = -1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                break;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        List<Integer> closestElements = new ArrayList<>();
        int elemLeftSide = mid - 1;
        int elemRightSide = mid + 1;

        int midCloset = Math.abs(x - arr[mid]);
        if (elemLeftSide >= 0) {
            if (elemRightSide < arr.length) {
                int rightDiff = Math.abs(arr[elemRightSide] - x);
                int leftDiff = Math.abs(arr[elemLeftSide] - x);
                if (leftDiff <= rightDiff) {
                    if (leftDiff <= midCloset) {
                        closestElements.add(arr[elemLeftSide]);
                        if(closestElements.size()!=k) {
                            closestElements.add(arr[mid]);
                        }
                        elemLeftSide--;
                    } else {
                        closestElements.add(arr[mid]);
                    }
                } else {
                    if (rightDiff < midCloset) {
                        closestElements.add(arr[elemRightSide]);
                        if(closestElements.size()!=k) {
                            closestElements.add(arr[mid]);
                        }
                        elemRightSide++;
                    } else {
                        closestElements.add(arr[mid]);
                    }
                }
            } else {
                if (Math.abs(arr[elemLeftSide] - x) <= Math.abs(arr[mid] - x)) {
                    closestElements.add(arr[elemLeftSide]);
                    if(closestElements.size()!=k) {
                        closestElements.add(arr[mid]);
                    }
                    elemLeftSide--;
                } else {
                    closestElements.add(arr[mid]);
                }
            }
        } else if (elemRightSide < arr.length) {
            if (Math.abs(arr[elemRightSide] - x) < Math.abs(arr[mid] - x)) {
                closestElements.add(arr[elemRightSide]);
                if(closestElements.size()!=k) {
                    closestElements.add(arr[mid]);
                }
                elemRightSide++;
            } else {
                closestElements.add(arr[mid]);
            }
        } else {
            closestElements.add(arr[mid]);
        }



        while (closestElements.size() != k && elemLeftSide >= 0 && elemRightSide < arr.length) {
            int leftElem = Math.abs(x - arr[elemLeftSide]);
            int rightElem = Math.abs(x - arr[elemRightSide]);
            if (leftElem <= rightElem) {
                closestElements.add(arr[elemLeftSide]);
                elemLeftSide--;
            } else {
                closestElements.add(arr[elemRightSide]);
                elemRightSide++;
            }
        }

        if (closestElements.size() != k) {
            while (elemLeftSide >= 0 && closestElements.size() != k) {
                closestElements.add(arr[elemLeftSide--]);
            }
        }

        if (closestElements.size() != k) {
            while (elemRightSide < arr.length && closestElements.size() != k) {
                closestElements.add(arr[elemRightSide++]);
            }
        }

        Collections.sort(closestElements);
        return closestElements;
    }
}
