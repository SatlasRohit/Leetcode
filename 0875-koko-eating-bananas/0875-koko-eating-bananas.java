class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        int ans = -1;

        // Find the maximum pile size
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // Binary Search
        while (low <= high) {

            // Generate a candidate eating speed
            int k = low + (high - low) / 2;

            // Calculate total hours required
            long totalHours = 0;

            for (int pile : piles) {
                totalHours += (pile + k - 1) / k;
            }

            // Check whether this speed is valid
            if (totalHours <= h) {
                ans = k;
                high = k - 1;  // Try a smaller speed
            } 
            else {
                low = k + 1;   // Increase the speed
            }
        }

        return ans;
        
    }
}