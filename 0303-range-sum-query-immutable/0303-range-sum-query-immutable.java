class NumArray {
    public int[] arr;
    public int[] num;
    public NumArray(int[] nums) {
        int n = nums.length;
        num = new int[n];
        arr = new int[n];
        arr[0] = nums[0];
        num[0] = nums[0];
        for(int i=1;i<n;i++){
            arr[i] = nums[i]+arr[i-1];
            num[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return arr[right]-(arr[left]-num[left]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */