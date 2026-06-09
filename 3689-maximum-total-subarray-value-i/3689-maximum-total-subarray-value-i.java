class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            if(n > max) max  = n;
            if(n < min) min = n;
        }
        return (long)(max-min)*k;
    }
}