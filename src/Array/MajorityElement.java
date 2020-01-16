package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MajorityElement {
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
            getMajorityElem(inputList);
            testCases--;
        }
    }

    public static void getMajorityElem(List<Integer> input)
    {
        int maxCntCheckVal = input.size()/2;
        int cnt = 0;
        int response = -1;

        Map<Integer,Integer> numFreqCntMap = new HashMap<>();
        for(int item : input)
        {
            cnt = 1;
            if(numFreqCntMap.containsKey(item))
            {
                cnt = numFreqCntMap.get(item);
                cnt++;
            }
            numFreqCntMap.put(item,cnt);
        }
        for(Map.Entry<Integer,Integer> mk : numFreqCntMap.entrySet())
        {
            if(mk.getValue()>maxCntCheckVal)
            {
                response = mk.getKey();
                break;
            }
        }

        System.out.println(response);
    }
}
