class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans=new int[n];
        int i=0,j=n-1,k=n-1;
        while(i<=j){
            int l=nums[i]*nums[i];
            int r=nums[j]*nums[j];
            if(r>l){
                ans[k]=r;
                j--;
                k--;
            }
            else{
                ans[k]=l;
                i++;
                k--;
            }
        }
        return ans;
    }
}