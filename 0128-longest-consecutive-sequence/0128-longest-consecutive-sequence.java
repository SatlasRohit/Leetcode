class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int maxcount = Integer.MIN_VALUE;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i]-1 == nums[i-1]){
                count++;
            }
            else{
                maxcount = Math.max(maxcount , count);
                count = 1;
            }
        }
        return Math.max(maxcount,count);
    }
}