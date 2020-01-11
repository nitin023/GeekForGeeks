package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * You are given an array A of size N. You need to print the total count of sub-arrays having their sum equal to 0
 * <p>
 * Input:
 * First line of the input contains an integer T denoting the number of test cases. Each test case consists of two lines. First line of each test case contains an Integer N denoting the size of the array, and the second line contains N space separated integers.
 * <p>
 * Output:
 * For each test case, in a new line, print the total number of subarrays whose sum is equal to 0.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1<= N <= 107
 * -1010 <= Ai <= 1010
 * <p>
 * Example:
 * Input:
 * 2
 * 6
 * 0 0 5 5 0 0
 * 10
 * 6  -1 -3 4 -2 2 4 6 -12 -7
 * <p>
 * Output:
 * 6
 * 4
 */
public class ZeroSumSubArrays {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());
        while (testCases > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<Long> list = new ArrayList<>();

            while (st.hasMoreElements())
            {
                list.add(Long.parseLong(st.nextToken()));
            }
            getZeroSubArrays(list);
            testCases--;
        }
    }

    /**
     * The algo works as--
     * Maintain sum of elements encountered so far in a variable (say sum).
     * If current sum is 0, we found a subarray starting from index 0 and ending at index current index
     * Check if current sum exists in the hash table or not.
     * If current sum already exists in the hash table then it indicates that this sum was the sum of some sub-array elements arr[0]…arr[i] and now the same sum is obtained for the current sub-array arr[0]…arr[j] which means that the sum of the sub-array arr[i+1]…arr[j] must be 0.
     * Insert current sum into the hash table
     * @param list
     */
    private static void getZeroSubArrays(List<Long> list) {
        Map<Long, List<Long>> sumMap = new HashMap<>();
        long sum = 0;
        long zeroCnt = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            List<Long> indexList = new ArrayList<>();
            if (sumMap.containsKey(sum)) {
                indexList = sumMap.get(sum);
            }

            indexList.add((long) i);
            sumMap.put(sum, indexList);
        }

        for(Map.Entry<Long,List<Long>> mE : sumMap.entrySet())
        {
            if(mE.getKey().equals(0L))
            {
                zeroCnt+= mE.getValue().size();
            }
             if(mE.getValue().size() > 1)
            {
                zeroCnt+= (mE.getValue().size() * (mE.getValue().size() -1)) / 2;
            }
        }
        System.out.println(zeroCnt);
    }
}
