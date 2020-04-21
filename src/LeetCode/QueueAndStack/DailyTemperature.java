package LeetCode.QueueAndStack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperature {

    public static void main(String[] args) {
        int[] response = dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        System.out.println(1);
    }

    public static int[] dailyTemperatures(int[] T) {
        if (T == null) {
            return null;
        }

        int[] response = new int[T.length];
        //73, 74, 75, 71, 69, 72, 76, 73
        for (int i = 0; i + 1 < T.length; i++) {
            int currentTemp = T[i]; //75
            int j = i + 1; //71

            if (currentTemp < T[j]) {
                response[i] = 1;
            } else {
                while (j < T.length && currentTemp >= T[j]) {
                    j++;
                }
                if (j < T.length && currentTemp < T[j]) {
                    response[i] = j - i;
                }
            }
        }
        return response;
    }
}
