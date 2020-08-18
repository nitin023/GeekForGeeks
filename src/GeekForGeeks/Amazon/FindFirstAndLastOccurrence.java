package GeekForGeeks.Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Easy
 * https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x/0
 */
public class FindFirstAndLastOccurrence {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            String target = br.readLine();
            int numElem = Integer.parseInt(target.split("-")[0]);
            int elemToFind = Integer.parseInt(target.split("-")[1]);
            String inputLine = br.readLine();
            findFirstAndLastOcc(numElem, elemToFind, inputLine);
            testCases--;
        }
    }

    private static void findFirstAndLastOcc(int numElem, int elemToFind, String inputStringList) {

        if (inputStringList == null || inputStringList.isEmpty()) {
            System.out.println("-1");
            return;
        }
        ;

        String[] intputStringArr = inputStringList.split(" ");
        int[] inputList = new int[numElem];

        for (int i = 0; i < numElem; i++) {
            inputList[i] = Integer.parseInt(intputStringArr[i].trim());
        }

        int indexFound = Arrays.binarySearch(inputList, elemToFind);
        if (indexFound < 0) {
            System.out.println("-1");
            return;
        }

        int startingIndex = indexFound, endIndex = indexFound;

        while (startingIndex >= 0) {
            if (startingIndex - 1 >= 0 && inputList[startingIndex] == inputList[startingIndex - 1]) {
                startingIndex--;
            } else {
                break;
            }
        }

        while (endIndex < numElem) {
            if (endIndex + 1 < numElem && inputList[endIndex] == inputList[endIndex + 1]) {
                endIndex++;
            } else {
                break;
            }
        }

        System.out.println(startingIndex + " " + endIndex);
    }
}
