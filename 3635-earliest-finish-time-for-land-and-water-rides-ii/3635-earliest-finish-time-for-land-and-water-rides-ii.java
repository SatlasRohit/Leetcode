
class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
    int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int[][] water = new int[m][2];
        for (int i = 0; i < m; i++) {
            water[i][0] = waterStartTime[i];
            water[i][1] = waterDuration[i];
        }

        Arrays.sort(water, (a, b) -> a[0] - b[0]);

        int[] wStarts = new int[m];

        long[] prefixMinDur = new long[m];
        long[] suffixMinOpenPlusDur = new long[m];

        for (int i = 0; i < m; i++) {
            wStarts[i] = water[i][0];
        }

        prefixMinDur[0] = water[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDur[i] =
                Math.min(prefixMinDur[i - 1], water[i][1]);
        }

        suffixMinOpenPlusDur[m - 1] =
            (long) water[m - 1][0] + water[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinOpenPlusDur[i] =
                Math.min(suffixMinOpenPlusDur[i + 1],
                         (long) water[i][0] + water[i][1]);
        }

        long ans = Long.MAX_VALUE;

        // Land -> Water
        for (int i = 0; i < n; i++) {

            long finishLand =
                (long) landStartTime[i] + landDuration[i];

            int pos = upperBound(wStarts, finishLand);

            if (pos > 0) {
                ans = Math.min(ans,
                        finishLand + prefixMinDur[pos - 1]);
            }

            if (pos < m) {
                ans = Math.min(ans,
                        suffixMinOpenPlusDur[pos]);
            }
        }

        int[][] land = new int[n][2];

        for (int i = 0; i < n; i++) {
            land[i][0] = landStartTime[i];
            land[i][1] = landDuration[i];
        }

        Arrays.sort(land, (a, b) -> a[0] - b[0]);

        int[] lStarts = new int[n];

        long[] prefixMinLandDur = new long[n];
        long[] suffixMinLandOpenPlusDur = new long[n];

        for (int i = 0; i < n; i++) {
            lStarts[i] = land[i][0];
        }

        prefixMinLandDur[0] = land[0][1];

        for (int i = 1; i < n; i++) {
            prefixMinLandDur[i] =
                Math.min(prefixMinLandDur[i - 1],
                         land[i][1]);
        }

        suffixMinLandOpenPlusDur[n - 1] =
            (long) land[n - 1][0] + land[n - 1][1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMinLandOpenPlusDur[i] =
                Math.min(suffixMinLandOpenPlusDur[i + 1],
                         (long) land[i][0] + land[i][1]);
        }

        // Water -> Land
        for (int i = 0; i < m; i++) {

            long finishWater =
                (long) waterStartTime[i] + waterDuration[i];

            int pos = upperBound(lStarts, finishWater);

            if (pos > 0) {
                ans = Math.min(ans,
                        finishWater + prefixMinLandDur[pos - 1]);
            }

            if (pos < n) {
                ans = Math.min(ans,
                        suffixMinLandOpenPlusDur[pos]);
            }
        }

        return (int) ans;
    }

    private int upperBound(int[] arr, long target) {

        int l = 0;
        int r = arr.length;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}