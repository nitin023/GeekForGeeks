package LeetCode.Easy.Arrays;

/**
 * 796. Rotate String
 */
public class RotateString {

    /**
     * Conventional Technique
     * @param A String
     * @param B String
     * @return boolean
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.length() < 2 && B.length() < 2) {
            return A.equals(B);
        }

        for (int i = 0; i + 1 < A.length(); i++) {

            StringBuilder start = new StringBuilder(A.substring(0, i + 1));
            StringBuilder end = new StringBuilder(A.substring(i + 1, A.length()));

            StringBuilder result = new StringBuilder(A.length());
            result.append(end).append(start);
            if (result.toString().equals(B)) {
                return true;
            }
        }
        return false;
    }

    /**
     * ON breaking of a string A into two parts
     * x being left and y being right
     * to make rotated string we have to add y to x to form yx
     * but if we concat xyxy than our yx is always part of it
     * @param A to rotate
     * @param B rotated string
     * @return
     */
    public boolean rotateStringFastest(String A, String B)
    {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() < 2 && B.length() < 2) {
            return A.equals(B);
        }

        StringBuilder xy = new StringBuilder(A);
        StringBuilder xyxy = new StringBuilder(A.length() * 2);
        xyxy.append(xy).append(xy);
        return xyxy.toString().contains(B);
    }
}
