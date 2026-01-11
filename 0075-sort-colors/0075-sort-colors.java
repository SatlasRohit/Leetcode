class Solution {
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        int j=nums.length-1;
        for(int i=0;i<nums.length/2;i++){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            j--;
        }
    }
}