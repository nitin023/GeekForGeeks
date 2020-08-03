package GeekForGeeks.Amazon;

import java.util.Collections;
import java.util.List;

/**
 * Minimum Platforms
 * Difficulty: Medium
 * https://practice.geeksforgeeks.org/problems/minimum-platforms/0
 * Greedy
 * <p>
 * Problems solution is by looking for smallest arrival and depart time
 * we sorted the arrival and depart list
 * this causes order to change but now we still have platform occupancy
 * so we start by looking for arrival and depart time after sorting
 * we checked if arrivalTime for a train A < depart time for train B then we need a platform
 * else same platform can be used
 */
public class MinimumPlatforms {

    private static int calculateMinNumPlatFormsGreedily(List<Integer> arrivalTime, List<Integer> departTime) {
        Collections.sort(arrivalTime);
        Collections.sort(departTime);

        int i = 0, j = 0, k = 0, minNumPlatforms = 0;

        while (i < arrivalTime.size() && j < departTime.size()) {
            if (arrivalTime.get(i) <= departTime.get(j)) {
                k++;
                i++;
            } else {
                k--;
                j++;
            }
            minNumPlatforms = Math.max(minNumPlatforms, k);
        }
        return minNumPlatforms;
    }
}
