package GeekForGeeks.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * https://practice.geeksforgeeks.org/problems/overlapping-intervals4919/1
 *
 * Problem can be easily solved by first sorting the list based on arrays starting points
 * after sorting list pick first interval compare its end value to adjacent interval start value
 * if the  interval overlaps then increase the end value of current interval
 * until a non-overlapping interval is found
 *
 * on founding non-overlapping interval update the list and compare this new value to other intervals
 * keep on iterating until list ends;
 */
public class OverlappingIntervals {


    public static void main(String[] args) {
        merge(new int[][]{{1,3},{2,6},{8,10},{10,18}});
    }
    public static int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int i = 1; i < intervals.length; i++) {
            if (newInterval[1] >= intervals[i][0]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                newInterval = intervals[i];
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
