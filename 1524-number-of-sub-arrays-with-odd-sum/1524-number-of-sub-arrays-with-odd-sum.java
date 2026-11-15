class Solution {

    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int n = arr.length;
        
        // dp to track counts for even and odd sum subarrays
        int[][] dp = new int[2][2];
        
        // Stores the final count of subarrays with an odd sum
        int count = dp[1][0];
        
        for (int i = 0; i < n; i++) {
            // Alternates between 0 and 1 for even/odd index tracking
            int idx = i & 1;
            // Determines if the current element is odd (1) or even (0)
            int parity = arr[i] & 1;
            
            // If the current element is odd, it contributes to odd subarrays
            // If the current element is even, it contributes to even subarrays
            dp[parity][idx] = (1 + dp[0][1 - idx]) % MOD;
            dp[1 - parity][idx] = dp[1][1 - idx] % MOD;
            
            // Accumulate the count of odd subarrays
            count = (count + dp[1][idx]) % MOD;
        }
        return count;
    }
}