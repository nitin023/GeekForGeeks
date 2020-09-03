package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
 * Easy
 */
public class FirstNonRepeatingCharInStream {

    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            int numElem = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            getFirstNonRepeatingCharInStream(numElem, input);
            testCases--;
        }
    }

    private static void getFirstNonRepeatingCharInStream(int numElem, String[] input) {
        if (numElem == 0) {
            System.out.println(-1);
            return;
        }
        Map<String, Integer> addElemInStreamMap = new LinkedHashMap();

        StringBuilder sb = new StringBuilder();
        for (String item : input) {
            int freq = 1;
            if (addElemInStreamMap.containsKey(item)) {
                //iterate to find 1 freq entry
                freq += addElemInStreamMap.get(item);
            }
            addElemInStreamMap.put(item, freq);
            sb.append(isAnyCharacterWithOneFreq(addElemInStreamMap)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static String isAnyCharacterWithOneFreq(Map<String, Integer> addElemInStreamMap) {
        for (Map.Entry<String, Integer> mk : addElemInStreamMap.entrySet()) {
            if (mk.getValue() == 1) {
                return mk.getKey();
            }
        }
        return "-1";
    }
}
