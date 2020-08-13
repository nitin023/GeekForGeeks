package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Count the triplets
 * https://practice.geeksforgeeks.org/problems/count-the-triplets/0
 * Solved using sorting plus hashmap
 * should use two pointer arithmetic
 */
public class CountTheTriplet {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            br.readLine();
            getTripletCountUsingTwoPtr(br.readLine());
            testCases--;
        }
    }

    /**
     * O(nlogn) plus O(n) extra space
     *
     * @param inputList
     */
    private static void getTripletCount(String inputList) {
        if (inputList == null || inputList.isEmpty()) {
            System.out.println("-1");
            return;
        }

        String[] input = inputList.split(" ");
        if (input.length < 3) {
            System.out.println("-1");
            return;
        }

        List<Integer> list = new ArrayList(input.length);
        Map<Integer, Integer> mk = new HashMap();

        for (int i = 0; i < input.length; i++) {
            int item1 = Integer.parseInt(input[i]);
            list.add(item1);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            mk.put(list.get(i), i);
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);

                if (mk.containsKey(sum)) {
                    int k = mk.get(sum);
                    if (k > i && k > j)
                        count++;
                }
            }
        }

        System.out.println(count == 0 ? -1 : count);
    }

    /**
     * Solution without using extra space and using two pointer approach
     * fastest solution
     * Approach is to start mark an element as the sum element prefer the largest element
     * start looking for search space excluding that elem (0....i-1 , where i is location of largest element)
     * now keep on updating your start , end pointer to make sum equal to chosen value (that is number on index i)
     * for multiple occurrences update and start and end pointer together once a solution is obtained
     * @param inputList
     */
    private static void getTripletCountUsingTwoPtr(String inputList) {
        if (inputList == null || inputList.isEmpty()) {
            System.out.println("-1");
            return;
        }

        String[] input = inputList.split(" ");
        if (input.length < 3) {
            System.out.println("-1");
            return;
        }

        List<Integer> list = new ArrayList(input.length);

        for (int i = 0; i < input.length; i++) {
            int item1 = Integer.parseInt(input[i]);
            list.add(item1);
        }
        Collections.sort(list);

        int count = 0;
        for (int i = list.size() - 1; i >= 2; i--) {
            count += isTwoSumTrue(list, list.get(i), i - 1);

        }
        System.out.println(count == 0 ? -1 : count);
    }

    private static int isTwoSumTrue(List<Integer> list, int sum, int end) {
        int start = 0;
        int counter = 0;
        while (start < end) {
            if (list.get(start) + list.get(end) < sum) {
                start++;
            } else if (list.get(start) + list.get(end) > sum) {
                end--;
            } else {
                start++;end--;
                counter++;
            }
        }
        return counter;
    }
}
