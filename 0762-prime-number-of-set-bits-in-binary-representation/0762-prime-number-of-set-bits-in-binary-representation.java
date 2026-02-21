class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int j = i;
            int setbit = 0;

            while (j > 0) {
                if ((j & 1) == 1) {
                    setbit++;
                }
                j >>= 1;
            }

            if (setbit < 2) continue;  // 0 & 1 not prime

            boolean isPrime = true;
            for (int k = 2; k * k <= setbit; k++) {
                if (setbit % k == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        return count;
    }
}