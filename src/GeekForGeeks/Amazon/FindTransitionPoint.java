package GeekForGeeks.Amazon;

//https://practice.geeksforgeeks.org/problems/find-transition-point-1587115620/1
//Solution using binary search easy problem
public class FindTransitionPoint {

    int transitionPoint(int a[], int n) {
        // code here
        if (n == 0) {
            return -1;
        }

        int index = -1;

        int low = 0, high = n - 1, mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == 0) {
                low = mid + 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }

        return index;
    }
}
