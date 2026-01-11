class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(nums[i]>nums[j]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        int j=n-1;
        for(int i=0;i<n/2;i++){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            j--;
        }
    }
}