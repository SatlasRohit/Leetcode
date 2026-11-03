class Solution {
    public int minMoves(int[] nums) {

        int res = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - max);
        }
        return res;
    }
}