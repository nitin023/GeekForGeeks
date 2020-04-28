package LeetCode.QueueAndStack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Flood Fill
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 */
public class FloodFill {

    public static void main(String[] args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        image = floodFill(image, 1, 1, 2);
        System.out.println(1);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;

        //invalid pixels
        if (sr < 0 || sr > rows || sc < 0 || sc > cols) {
            return image;
        }

        String pixelKey = sr + "|" + sc + "";
        Set<String> visitedPixels = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.add(pixelKey);

        while (!stack.isEmpty()) {
            pixelKey = stack.pop();
            if (!visitedPixels.contains(pixelKey)) {
                String[] pixelArray = pixelKey.split("\\|");
                int pixelRow = Integer.parseInt(pixelArray[0]);
                int pixelCol = Integer.parseInt(pixelArray[1]);
                visitedPixels.add(pixelKey);

                int pixelColor = image[pixelRow][pixelCol];
                image[pixelRow][pixelCol] = newColor;

                //all neighbour
                //left
                if (pixelCol - 1 >= 0 && pixelCol - 1 < cols && image[pixelRow][pixelCol - 1] == pixelColor) {
                    stack.push(pixelRow + "|" + (pixelCol - 1));
                }
                //right
                if (pixelCol + 1 < cols && image[pixelRow][pixelCol + 1] == pixelColor) {
                    stack.push(pixelRow + "|" + (pixelCol + 1));
                }
                //top
                if (pixelRow - 1 >= 0 && image[pixelRow - 1][pixelCol] == pixelColor) {
                    stack.push((pixelRow - 1) + "|" + pixelCol);
                }
                //bottom
                if (pixelRow + 1 < rows && image[pixelRow + 1][pixelCol] == pixelColor) {
                    stack.push((pixelRow + 1) + "|" + pixelCol);
                }
            }
        }
        return image;
    }
}
