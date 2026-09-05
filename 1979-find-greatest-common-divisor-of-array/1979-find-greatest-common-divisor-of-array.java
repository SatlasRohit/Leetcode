class Solution {
    public int GCD(int a , int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min) min = nums[i];
            if(nums[i]>max) max = nums[i];
        }
        return GCD(max,min);
    }
}