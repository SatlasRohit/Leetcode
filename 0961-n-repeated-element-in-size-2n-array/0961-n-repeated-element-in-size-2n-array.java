class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]==nums[j]){
                    return nums[j];
                }
            }
        }
        return 0;
    }
}