class NumArray {
    public int[] prefix;
    public NumArray(int[] nums) {
        int n = nums.length;
        prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = nums[i]+prefix[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = prefix[right];
        if(left>0) sum-=prefix[left-1];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */