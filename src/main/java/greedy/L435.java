package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yaosen.pys
 * @date 2021/07/10
 */
public class L435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[1] < b[1] ? -1 : (a[1] == b[1] ? 0 : 1);
        });

        int value = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                value++;
                end = intervals[i][1];
            }
        }
        return intervals.length - value;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0][0] = 1;
        intervals[0][1] = 100;
        intervals[1][0] = 11;
        intervals[1][1] = 22;
        intervals[2][0] = 1;
        intervals[2][1] = 11;
        intervals[3][0] = 2;
        intervals[3][1] = 12;

        System.out.println(eraseOverlapIntervals(intervals));
    }
}
