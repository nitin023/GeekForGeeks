package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MissingNumberInArray {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases>0)
        {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> inputList = new ArrayList<>();

            while (st.hasMoreElements())
            {
                inputList.add(Integer.parseInt(st.nextToken()));
            }
            getMissingNumber(inputList,numElem);
            testCases--;
        }
    }

    /**
     * done using xor
     *  1) XOR all the array elements, let the result of XOR be X1.
     *   2) XOR all numbers from 1 to n, let XOR be X2.
     *   3) XOR of X1 and X2 gives the missing number.
     * @param inputList
     * @param numElem
     */
    public static void getMissingNumber(List<Integer> inputList , int numElem)
    {
       int xor1 = 1, xor2 = inputList.get(0);
       for(int i = 2 ; i <= numElem ; i++)
       {
           xor1 ^= i;
       }
       for(int i = 1 ;i <inputList.size() ; i++)
       {
           xor2 ^= inputList.get(i);
       }
        System.out.println(xor1 ^ xor2);
    }
}
