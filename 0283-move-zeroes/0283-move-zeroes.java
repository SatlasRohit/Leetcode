class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0,j = 0;
        int n = nums.length;
        while(i<n){
            if(nums[i] == 0){
                i++;
                continue;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
            i++;
        }
    }
}