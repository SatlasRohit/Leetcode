import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        // Faster than lambda comparator
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int n = intervals.length;
        int[][] res = new int[n][2];
        int idx = 0;

        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= res[idx][1]) {
                // merge
                res[idx][1] = Math.max(res[idx][1], intervals[i][1]);
            } else {
                idx++;
                res[idx][0] = intervals[i][0];
                res[idx][1] = intervals[i][1];
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }
}
