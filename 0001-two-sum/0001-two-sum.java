class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sum=new int[2];
        int len=nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]+nums[j]==target){
                    sum[0]=i;
                    sum[1]=j;
                    break;
                }
            }
        }
        return sum;
    }
}