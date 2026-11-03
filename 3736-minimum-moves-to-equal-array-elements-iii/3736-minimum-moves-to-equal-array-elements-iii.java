class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int median = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - median);
        }
        return res;
    }
}