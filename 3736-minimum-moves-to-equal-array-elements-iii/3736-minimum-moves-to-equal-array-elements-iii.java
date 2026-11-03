class Solution {
    public int minMoves(int[] nums) {
        int res = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            res += nums[i];
        }
        return n * max - res;
    } 
}