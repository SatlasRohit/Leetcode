class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum=0;
        int max=0;
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==1){
                sum++;
            }
            else{
                max=max(sum,max);
                sum=0;
            }
        }
        return max(sum,max);
    }
    public int max(int sum,int max){
        if(sum>max){
            return sum;
        }
        return max;
    }
}