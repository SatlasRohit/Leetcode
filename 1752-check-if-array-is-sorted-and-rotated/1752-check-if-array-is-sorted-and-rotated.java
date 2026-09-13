class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int flag = 0 ;
        for(int i=0;i<n;i++){
            if(nums[i] > nums[(i+1)%n]) flag++;// If the Array is sorted lesser value comes only once if it is not sorted the lesser value comes more than 1
            if(flag > 1) return false;
        }
        return true;
    }
}