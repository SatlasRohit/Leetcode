class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];

        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];

        // first column
        for (int i = 1; i < m; i++) {
            maxDp[i][0] = maxDp[i-1][0] * grid[i][0];
            minDp[i][0] = minDp[i-1][0] * grid[i][0];
        }

        // first row
        for (int j = 1; j < n; j++) {
            maxDp[0][j] = maxDp[0][j-1] * grid[0][j];
            minDp[0][j] = minDp[0][j-1] * grid[0][j];
        }

        // fill DP
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];

                long maxVal = Math.max(
                    Math.max(maxDp[i-1][j] * val, minDp[i-1][j] * val),
                    Math.max(maxDp[i][j-1] * val, minDp[i][j-1] * val)
                );

                long minVal = Math.min(
                    Math.min(maxDp[i-1][j] * val, minDp[i-1][j] * val),
                    Math.min(maxDp[i][j-1] * val, minDp[i][j-1] * val)
                );

                maxDp[i][j] = maxVal;
                minDp[i][j] = minVal;
            }
        }

        long result = maxDp[m-1][n-1];

        if (result < 0) return -1;

        return (int)(result % 1000000007);
    }
}