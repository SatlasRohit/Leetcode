class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int low = 0,high = n - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            min = Math.min(min,nums[mid]);
            if(nums[mid] < min){
                if(nums[mid] >= nums[low]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            else{
                if(nums[mid] <= nums[high]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
        }
        return min;
    }
}