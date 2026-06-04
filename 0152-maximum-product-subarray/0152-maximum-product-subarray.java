class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int[] maxDp = new int[n];
        int[] minDp = new int[n];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        int ans = nums[0];

        for (int i = 1; i < n; i++) {

            maxDp[i] = Math.max(
                nums[i],
                Math.max(
                    nums[i] * maxDp[i - 1],
                    nums[i] * minDp[i - 1]
                )
            );

            minDp[i] = Math.min(
                nums[i],
                Math.min(
                    nums[i] * maxDp[i - 1],
                    nums[i] * minDp[i - 1]
                )
            );

            ans = Math.max(ans, maxDp[i]);
        }

        return ans;
    }
}