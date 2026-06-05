class Solution {
    // directions
    static final int NONE = 0, UP = 1, DOWN = 2, FLAT = 3;

    int[] digits;
    Map<Long, long[]> memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    long solve(long num) {
        if (num <= 0)
            return 0;
        memo = new HashMap<>();

        // split num into digits
        String s = Long.toString(num);
        digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }

        return dp(0, 0, NONE, true, false)[1];
    }

    // returns [count of numbers, total waviness sum]
    long[] dp(int pos, int prev, int dir, boolean tight, boolean started) {
        if (pos == digits.length) {
            return new long[] { started ? 1 : 0, 0 };
        }

        long key = ((long) pos * 10 + prev) * 4 + dir;
        key = key * 2 + (tight ? 1 : 0);
        key = key * 2 + (started ? 1 : 0);
        if (memo.containsKey(key))
            return memo.get(key);

        int limit = tight ? digits[pos] : 9;
        long count = 0, waveSum = 0;

        for (int d = 0; d <= limit; d++) {
            boolean newTight = tight && (d == limit);
            boolean newStarted = started || (d != 0);

            // determine new prev and direction
            int newPrev, newDir;
            if (!newStarted) {
                // still leading zeros
                newPrev = 0;
                newDir = NONE;
            } else if (!started) {
                // first real digit
                newPrev = d;
                newDir = NONE;
            } else {
                newPrev = d;
                if (d > prev)
                    newDir = UP;
                else if (d < prev)
                    newDir = DOWN;
                else
                    newDir = FLAT;
            }

            // check if prev digit becomes a peak or valley
            long extra = 0;
            if (started) {
                if (dir == UP && d < prev)
                    extra = 1; // prev was peak
                if (dir == DOWN && d > prev)
                    extra = 1; // prev was valley
            }

            long[] sub = dp(pos + 1, newPrev, newDir, newTight, newStarted);
            count += sub[0];
            waveSum += sub[1] + extra * sub[0];
        }

        long[] res = new long[] { count, waveSum };
        memo.put(key, res);
        return res;
    }
}