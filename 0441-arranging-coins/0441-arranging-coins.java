class Solution {
    public int arrangeCoins(int n) {
        long N = n;
        return (int)((Math.sqrt(8 * N + 1) - 1) / 2);
    }
}