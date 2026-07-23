class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq = new int[nums.length];
        for(int n : nums){
            if(freq[n]>=1) return n;
            freq[n]++;
        }
        return -1;
    }
}