class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int min=Integer.MAX_VALUE;
        int i=0,j=n-1;
        while(i<=j){
            if(nums[i]<min) min=nums[i];
            if(nums[j]<min) min=nums[j];
            i++;
            j--;
        }
        return min;
    }
}