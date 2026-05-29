class Solution {
    public int minElement(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int digit=nums[i];
            int sum=0;
            while(digit>9){
                sum+=digit%10;
                digit/=10;
            }
            sum+=digit;
            if(sum<min) min=sum;
        }
        return min;
    }
}