package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FourElements {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            br.readLine();
            String inputLine = br.readLine();
            String target = br.readLine();
            get4ElementsSumCountFastest(inputLine, Integer.parseInt(target));
            testCases--;
        }
    }

    /**
     * O(N3)
     *
     * @param inputLine
     * @param target
     */
    private static void get4ElementsSumCount(String inputLine, int target) {
        String[] arr = inputLine.split(" ");
        List<Integer> inputList = new ArrayList(arr.length);
        if (arr.length < 3) {
            System.out.println(0);
            return;
        }

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            int input = Integer.parseInt(arr[i].trim());
            inputList.add(input);
            map.put(input, i);
        }

        int length = inputList.size();
        int counter = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = target - (inputList.get(i) + inputList.get(j) + inputList.get(k));
                    if (map.containsKey(sum)) {
                        int index = map.get(sum);
                        if (index != i && index != j && index != k) {
                            counter++;
                        }
                    }
                }
            }
        }

        System.out.println(counter > 0 ? 1 : 0);
    }

    /**
     * O(N2) fastest approach
     * using hashmap to evaluate pair sum then iterate over hashmap and only enter pairs for which target >  sum
     * iterate over map for each of these values and try to find out the diff sum using target - sum and if diff
     * do exist just find that if it exists over diff index then current sum elements if so problem is solved
     * @param inputLine
     * @param target
     */
    private static void get4ElementsSumCountFastest(String inputLine, int target) {
        String[] arr = inputLine.split(" ");
        if (arr.length < 3) {
            System.out.println(0);
            return;
        }

        Map<Integer, Set<String>> pairSumMap = new HashMap<>();
        List<Integer> list = new ArrayList<>(arr.length);
        for (String s : arr) {
            list.add(Integer.parseInt(s.trim()));
        }

        int sum = 0, diff = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = list.get(i) + list.get(j);
                if (sum < target) {
                    pairSumMap.putIfAbsent(sum, new HashSet<>());
                    pairSumMap.get(sum).add(i + "-" + j);
                }
            }
        }

        for (Map.Entry<Integer, Set<String>> mk : pairSumMap.entrySet()) {
            diff = target - mk.getKey();
            if (pairSumMap.containsKey(diff)) {
                Set<String> indexesList = mk.getValue();
                for (String index : indexesList) {
                    int indexOrgX = Integer.parseInt(index.split("-")[0]);
                    int indexOrgY = Integer.parseInt(index.split("-")[1]);
                    for (String newIdx : pairSumMap.get(diff)) {
                        int indexNewX = Integer.parseInt(newIdx.split("-")[0]);
                        int indexNewY = Integer.parseInt(newIdx.split("-")[1]);
                        if (indexOrgX != indexNewX && indexOrgX != indexNewY && indexOrgY != indexNewX && indexOrgY != indexNewY) {
                            System.out.println(1);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
