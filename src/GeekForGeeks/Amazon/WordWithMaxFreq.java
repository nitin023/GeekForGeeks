package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://practice.geeksforgeeks.org/problems/word-with-maximum-frequency/0
 * Easy GFG
 *
 * Approach
 * Step create a linked hashmap as it helps to preserve word order
 * after map prep iterate over map to find word with max frequency
 */
public class WordWithMaxFreq {

    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            getMaxFreqWord(br.readLine());
            testCases--;
        }
    }

    private static void getMaxFreqWord(String wordString) {

        if (wordString == null) {
            System.out.println("null 0");
            return;
        }
        if (wordString.isEmpty()) {
            System.out.println(" 0");
            return;
        }


        String[] arr = wordString.split(" ");

        Map<String, Integer> map = new LinkedHashMap(arr.length);

        for (int i = 0; i < arr.length; i++) {
            String item = arr[i].trim();
            int freq = 1;

            if (map.containsKey(item)) {
                freq += map.get(item);
            }
            map.put(item, freq);
        }

        int maxFreq = 0;
        String wordWithMaxFreq = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                wordWithMaxFreq = entry.getKey();
            }
        }
        System.out.println(wordWithMaxFreq + " " + maxFreq);

    }
}
