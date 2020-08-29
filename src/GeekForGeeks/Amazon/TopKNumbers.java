package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/top-k-numbers/0
 * Medium
 * Priority Queue , HashMap
 */
public class TopKNumbers {

    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            String input = br.readLine();
            int numElem = Integer.parseInt(input.split(" ")[0]);
            int numOfTopKElem = Integer.parseInt(input.split(" ")[1]);

            String[] arr = br.readLine().split(" ");
            getTopKElementsAsPerFreq(arr, numElem, numOfTopKElem);
            testCases--;
        }
    }

    private static void getTopKElementsAsPerFreq(String[] arr, int numElem, int numOfTopKElem) {
        Map<Integer, Node> inputStreamElementsFreqMap = new HashMap();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(numElem, new NodeComparator());
        StringBuilder stringBuilder = new StringBuilder(numElem * numOfTopKElem);
        for (String item : arr) {
            int value = Integer.parseInt(item);
            int freq = 1;
            if (inputStreamElementsFreqMap.containsKey(value)) {
                freq = inputStreamElementsFreqMap.get(value).freq + 1;
                priorityQueue.remove(inputStreamElementsFreqMap.get(value));
            }
            inputStreamElementsFreqMap.put(value, new Node(value, freq));
            Node addNewNode = new Node(value, freq);
            priorityQueue.offer(addNewNode);
            List<Node> priorityQueueList = new ArrayList<>(priorityQueue.size());
            while (!priorityQueue.isEmpty()) {
                priorityQueueList.add(priorityQueue.poll());
            }

            int topCnt = 0;
            for (int i = 0; i < priorityQueueList.size() && topCnt < numOfTopKElem; i++, topCnt++) {
                stringBuilder.append(priorityQueueList.get(i).value).append(" ");
            }

            priorityQueue.addAll(priorityQueueList);
        }
        System.out.println(stringBuilder.toString());

    }

    static class Node {
        int value;
        int freq;

        Node(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        public boolean equals(Object o)
        {
            Node node = (Node)o;
            return this.value==((Node) o).value ;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.freq != b.freq ? b.freq - a.freq : a.value - b.value;
        }
    }
}
