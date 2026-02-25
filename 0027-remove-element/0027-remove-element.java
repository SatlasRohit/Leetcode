class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;  // position for next valid element
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k;
    }
}