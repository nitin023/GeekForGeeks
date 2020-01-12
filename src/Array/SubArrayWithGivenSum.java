package Array;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubArrayWithGivenSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0)
        {
            st = new StringTokenizer(br.readLine());
            int numElem = Integer.parseInt(st.nextToken());
            int givenSum = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            while (st.hasMoreElements())
            {
                list.add(Integer.parseInt(st.nextToken()));
            }
            getSubArrayWithGivenSum(list,givenSum);
            testCases--;
        }
    }

    /**
     * solved by making a sum to index map and at a point we get sum value
     * after that iff we found a sum > givenSum
     * we find there diff and using sum we find that diff in map
     * if it exists we found the indexes else we keep on searching
     * if we not able to get that sum we return -1
     * @param list
     * @param givenSum
     */
    private static void getSubArrayWithGivenSum(List<Integer> list , int givenSum)
    {
        Map<Long,Integer> sumTillIndexMap = new LinkedHashMap<>();
        long sum = 0;
        int currIndex = 0;
        for(int item : list)
        {
            sum+=item;
            sumTillIndexMap.put(sum,currIndex);
            if(sum==givenSum)
            {
                System.out.println("1 " + (currIndex + 1));
                return;
            }
            if(sum > givenSum)
            {
                long diff = sum - givenSum;
                if(sumTillIndexMap.containsKey(diff))
                {
                    System.out.println((sumTillIndexMap.get(diff) + 2) + " " + (currIndex + 1 ));
                    return;
                }
            }
            currIndex++;
        }
        System.out.println(-1);
    }
}
