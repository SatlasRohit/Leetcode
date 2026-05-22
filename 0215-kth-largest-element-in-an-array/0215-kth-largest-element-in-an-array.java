class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;

        if(k<=n){
            Arrays.sort(nums);
            return nums[n-k];
        }
        return -1;
    }
}