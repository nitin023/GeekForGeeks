package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EquilibriumPoint {
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
                getEquilibriumPoints(inputList,numElem);
                testCases--;
            }
        }

    /**
     * Two pointer arithmetic approach
     * make fwdSum and revSum values to find equilibrium point
     * @param requestList
     * @param numElem
     */
    private static void getEquilibriumPoints(List<Integer> requestList , int numElem)
    {
        int equibriumPoint = -1;
        int fwdSum = 0  , revSum = 0;
        for(int i = 0  , j = numElem - 1; i < requestList.size() ;)
        {
            if(i == 0)
            {
                fwdSum+=requestList.get(i);
                revSum+=requestList.get(j);
                i++;j--;
            }
            else if(fwdSum == revSum && i == j)
            {
                equibriumPoint = i+1;
                break;
            }
            else if(fwdSum < revSum)
            {
                fwdSum += requestList.get(i);
                i++;
            }
            else
            {
                revSum += requestList.get(j);
                j--;
            }
            if(i>j)
            {
                break;
            }
        }
        if(equibriumPoint == -1 && numElem == 1)
        {
            equibriumPoint = 1;
        }
        System.out.println(equibriumPoint);
    }
}
