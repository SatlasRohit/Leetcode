class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            
            int sum=0;
            while(nums[i]>9){
                sum+=nums[i]%10;
                nums[i]/=10;
            }
            sum+=nums[i];
            if(sum<min) min=sum;
        }
        return min;
    }
}