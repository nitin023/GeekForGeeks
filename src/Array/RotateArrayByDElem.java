package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Given an unsorted array arr[] of size N, rotate it by D elements (clockwise).
 *
 * Input:
 * The first line of the input contains T denoting the number of testcases. First line of each test case contains two space separated elements, N denoting the size of the array and an integer D denoting the number size of the rotation. Subsequent line will be the N space separated array elements.
 *
 * Output:
 * For each testcase, in a new line, output the rotated array.
 *
 * Constraints:
 * 1 <= T <= 200
 * 1 <= N <= 107
 * 1 <= D <= N
 * 0 <= arr[i] <= 105
 *
 * Example:
 * Input:
 * 2
 * 5 2
 * 1 2 3 4 5
 * 10 3
 * 2 4 6 8 10 12 14 16 18 20
 *
 * Output:
 * 3 4 5 1 2
 * 8 10 12 14 16 18 20 2 4 6
 *
 * Explanation :
 * Testcase 1: 1 2 3 4 5  when rotated by 2 elements, it becomes 3 4 5 1 2.
 */
public class RotateArrayByDElem {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases>0)
        {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());
            int numRotations = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> inputList = new ArrayList<>();

            while (st.hasMoreElements())
            {
                inputList.add(Integer.parseInt(st.nextToken()));
            }
            rotateArrayByDElements(inputList,numRotations,numElem);
            testCases--;
        }
    }

    public static void rotateArrayByDElements(List<Integer> arrayList, int numRotations,int numElem)
    {
        StringBuilder response = new StringBuilder();
        int indexOfRotations = 0;
        while (numRotations>0)
        {
            numRotations--;
            response.append(arrayList.get(indexOfRotations)).append(" ");
            indexOfRotations++;
        }
        StringBuilder sk = new StringBuilder();
        for(int i = indexOfRotations; i < arrayList.size() ; i++)
        {
            sk.append(arrayList.get(i)).append(" ");
        }
        System.out.println( sk.append(response));
    }
}
