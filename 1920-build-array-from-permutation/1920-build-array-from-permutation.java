class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        solve(ans,nums,0);
        return ans;
    }
    public void solve(int[] ans,int[] nums,int index){
        if(index == nums.length) return;
        ans[index] = nums[nums[index]];
        solve(ans,nums,index+1);
    }
}