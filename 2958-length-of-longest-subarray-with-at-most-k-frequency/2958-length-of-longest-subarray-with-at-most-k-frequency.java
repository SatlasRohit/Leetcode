class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        if(n<2) return 1;
        int left = 0 , right = 1;
        int max = 0;
        HashMap<Integer,Integer> freq = new HashMap<>();
        freq.put(nums[0],1);

        while(right<n){
            freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);

            while(freq.get(nums[right])>k){
                freq.put(nums[left],freq.getOrDefault(nums[left],0)-1);
                left++;
            }

            max = Math.max(max,(right-left)+1);
            right++;
        }
        return max;
    }
}