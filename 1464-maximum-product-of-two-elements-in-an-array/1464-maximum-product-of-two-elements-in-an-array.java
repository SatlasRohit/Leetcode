class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]>=max1){
        //         max2 = max1;
        //         max1 = nums[i];
        //     }
        // }
        return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);
    }
}