class Solution {

    int[] dp;

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;
        dp = new int[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, d, i));
        }

        return ans;
    }

    private int dfs(int[] arr, int d, int i) {

        // Already calculated
        if (dp[i] != 0) {
            return dp[i];
        }

        int max = 1;

        // Check left side
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {

            // Blocked by bigger/equal element
            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + dfs(arr, d, j));
        }

        // Check right side
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {

            // Blocked by bigger/equal element
            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + dfs(arr, d, j));
        }

        dp[i] = max;

        return max;
    }
}