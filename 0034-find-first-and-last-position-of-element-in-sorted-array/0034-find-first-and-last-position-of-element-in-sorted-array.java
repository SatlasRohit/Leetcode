class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = firstOccurance(nums,target);
        int last = lastOccurance(nums,target);
        return new int[]{first,last};
    }
    public int firstOccurance(int[] nums,int target){
        int left = 0,right = nums.length-1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right-left ) / 2;
            if(nums[mid] == target){
                ans = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public int lastOccurance(int[] nums,int target){
        int left = 0,right = nums.length-1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                ans = mid;
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
