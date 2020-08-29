package GeekForGeeks.Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * https://practice.geeksforgeeks.org/problems/index-of-an-extra-element/1
 */
public class IndexOfAnExtraElement {

    /**
     * Solution in O(N) time used hashing to find missing element
     *
     * @param a
     * @param b
     * @param n
     * @return
     */
    public int findExtra(int a[], int b[], int n) {
        // add code here.

        Map<Integer, Integer> map = new HashMap();
        if (a.length < b.length) {
            for (int i = 0; i < a.length; i++) {
                map.put(a[i], i);
            }

            for (int i = 0; i < b.length; i++) {
                if (!map.containsKey(b[i])) {
                    return i;
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * All elements except diff value will be on same index apply binary search once we get diff in two array elements then we can found that index
     * @param a
     * @param b
     * @return
     */
    public int findExtraWithBinarySearch(int a[], int b[]) {
        int low = 0, mid, high = a.length < b.length ? a.length - 1 : b.length - 1;
        int index = high + 1;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (a[mid] == b[mid]) {
                low = mid + 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }
}
