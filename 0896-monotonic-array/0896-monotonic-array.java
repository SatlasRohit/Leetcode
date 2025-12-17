class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums[0] >= (nums[nums.length - 1])) {
            for (int i = 0;i < nums.length;i++) {
                if (i == nums.length - 1) {
                    break;
                }
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
                continue;
            } 
        }
        else if (nums[0] <= nums[nums.length - 1]) {
            for (int i = 0;i < nums.length;i++) {
                if (i == nums.length - 1) {
                    break;
                }
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
}