class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];   // Descending end if starts are equal
            }
            return a[0] - b[0];       // Ascending start
        });

        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][1] > end) {
                count++;
                end = intervals[i][1];
            }
            // Otherwise, this interval is covered.
        }
        
        return count;
    }
}