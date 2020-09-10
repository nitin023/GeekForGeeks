package Array;

import java.util.Optional;

public class DetermineMountain {

    public static void main(String[] args) {
        //System.out.println(validMountainArray(new int[]{1,2,3,5,7,9,10,12,14,15,16,18,14,13}));
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
    }

    public static boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }

        int i;
        boolean isMountainStricltyIncreasing = false;
        for (i = 0; i + 1 < A.length; i++) {
            if (i > 0 && A[i - 1] < A[i] && A[i] > A[i + 1]) {
                isMountainStricltyIncreasing = true;
                break;
            } else if (A[i] > A[i + 1]) {
                if (!isMountainStricltyIncreasing) {
                    return false;
                }
            }
        }

        if (isMountainStricltyIncreasing) {
            while (i + 1 < A.length) {
                if (A[i + 1] >= A[i]) {
                    return false;
                }
                i++;
            }
            return true;
        }
        return false;
    }
}
