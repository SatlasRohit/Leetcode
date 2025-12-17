class Solution {
    public int[] buildArray(int[] nums) {
        int [] ans=new int[nums.length];
        int j=0;
        for(int i:nums){
            ans[j]=nums[i];
            j++;
        }
        return ans;
    }
}