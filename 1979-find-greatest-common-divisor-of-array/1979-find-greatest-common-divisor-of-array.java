class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        // System.out.println(min);
        // System.out.println(max);
        while(max != 0){
            int temp = max;
            max = min % max;
            min = temp;
        }
        return min;
    }
}