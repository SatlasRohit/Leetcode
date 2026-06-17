class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        
        return nums;
    }
}