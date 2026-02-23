class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int need = 1 << k;  // 2^k
        
        // Quick fail: not enough substrings of length k
        if (n - k + 1 < need) return false;

        boolean[] seen = new boolean[need];
        int mask = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Shift left, keep only k bits, add current bit
            mask = ((mask << 1) & (need - 1)) | (s.charAt(i) - '0');

            // Start checking once window size reaches k
            if (i >= k - 1) {
                if (!seen[mask]) {
                    seen[mask] = true;
                    count++;

                    // If all 2^k codes seen → success
                    if (count == need) return true;
                }
            }
        }

        return false;
    }
}