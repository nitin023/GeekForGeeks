package GeekForGeeks.Amazon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountTheElements {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            int numElem = Integer.parseInt(br.readLine());
            String inputA = br.readLine();
            String inputB = br.readLine();
            int numQueries = Integer.parseInt(br.readLine());
            String[] inputBStrArr = inputB.split(" ");
            int[] inputBIntList = new int[numElem];
            for (int i = 0; i < numElem; i++) {
                inputBIntList[i] = Integer.parseInt(inputBStrArr[i]);
            }
            Arrays.sort(inputBIntList);

            String[] inputAStrArr = inputA.split(" ");

            while (numQueries > 0) {
                int index = Integer.parseInt(br.readLine());
                getNumElementsSmallerThanGivenIndexInB(index, inputAStrArr, inputBIntList);
                numQueries--;
            }
            testCases--;
        }
    }

    private static void getNumElementsSmallerThanGivenIndexInB( int index, String[] inputAStrArr, int[] inputBIntList) {
        int val = Integer.parseInt(inputAStrArr[index]);
        int findIndex = Arrays.binarySearch(inputBIntList, val);
        if (findIndex > -1) {
            System.out.println(index + 1);
            return;
        }

        findIndex = Math.abs(findIndex) - 1;
        System.out.println(findIndex);
    }
}
