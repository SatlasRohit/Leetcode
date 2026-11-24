class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = -1;
        for(int i=0;i<n;i++){
            high = Math.max(high , nums[i]);
        }
        while(low <= high){
            int mid =low + (high - low)/2;
            int sum = Calculatesum(nums,mid);
            if(sum <= threshold){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int Calculatesum(int[] nums,int divisor){
        int sum = 0;
        for(int num : nums){
            sum += (num + divisor -1)/divisor;
        }
        return sum;
    }
}