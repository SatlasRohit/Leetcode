class Solution {
    public int arrangeCoins(int n) {
        long N = n; // to avoid overflow
        return (int)((Math.sqrt(8 * N + 1) - 1) / 2);
    }
}
