class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rightsum=0,leftsum=0,n=nums.length;

        for(int num : nums) rightsum+=num;

        for(int i = 0 ; i < n ; i++){

            int val = nums[i];
            rightsum-=val;
            nums[i] = Math.abs(leftsum - rightsum);
            leftsum+=val;
            
        }
        return nums;
    }
}