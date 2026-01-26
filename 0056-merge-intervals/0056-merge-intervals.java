class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        // 1️⃣ Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> result = new ArrayList<>();

        // 2️⃣ Start with first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // 3️⃣ Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // Overlapping case
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            // Non-overlapping case
            else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add last interval
        result.add(new int[]{start, end});

        // 4️⃣ Convert ArrayList to array
        return result.toArray(new int[result.size()][]);
    }
}
