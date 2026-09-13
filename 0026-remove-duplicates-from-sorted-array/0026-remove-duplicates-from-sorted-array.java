class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        for(int i=1;i<n;i++){
            if(nums[i] == nums[j]) continue; // Continue until the num[i] & nums[j] are equal 
            nums[++j] = nums[i];//If the nums[i] & nums[j] are not equal then pass value from i to j
        }
        return j+1;
    }
}