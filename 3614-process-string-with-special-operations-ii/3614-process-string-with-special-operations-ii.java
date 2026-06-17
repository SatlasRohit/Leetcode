class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];

        // Forward pass: compute the length after each operation
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (ch == '#') {
                len[i + 1] = len[i] * 2;
            } else if (ch == '%') {
                len[i + 1] = len[i];
            } else {
                len[i + 1] = len[i] + 1;
            }

            // Prevent overflow
            if (len[i + 1] > Long.MAX_VALUE / 2) {
                len[i + 1] = Long.MAX_VALUE;
            }
        }

        if (k >= len[n]) {
            return '.';
        }

        // Backward pass
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '*') {
                // Before '*' the string was one character longer.
                // k stays the same.
            } else if (ch == '#') {
                long prevLen = len[i];
                k %= prevLen;
            } else if (ch == '%') {
                long prevLen = len[i];
                k = prevLen - 1 - k;
            } else {
                long prevLen = len[i];

                if (k == prevLen) {
                    return ch;
                }
                // Otherwise, this character wasn't the one we're looking for.
            }
        }

        return '.';
    }
}