class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        if(n < 2) return nums[0];
        int low = 0,high = n - 1;
        HashSet<Integer> set = new HashSet<>();
        while(low <= high){
            if(nums[low + 1] == nums[low]) low+=2;
            else return nums[low];
            if(nums[high - 1] == nums[high]) high -=2;
            else return nums[high];
        }
        return -1;
    }
}