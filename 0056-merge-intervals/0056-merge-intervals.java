import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Edge case
        if (intervals == null || intervals.length <= 1)
            return intervals;

        // 1️⃣ Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> merged = new ArrayList<>();

        // 2️⃣ Initialize with first interval
        int start = intervals[0][0];
        int end   = intervals[0][1];

        // 3️⃣ Traverse and merge
        for (int i = 1; i < intervals.length; i++) {

            // Overlapping intervals
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            // Non-overlapping interval
            else {
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end   = intervals[i][1];
            }
        }

        // Add the last interval
        merged.add(new int[]{start, end});

        // 4️⃣ Convert ArrayList to 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}
