class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int pivot = -1;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Case: no next permutation
        if(pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Find rightmost element greater than pivot
        for(int i = n - 1; i > pivot; i--) {
            if(nums[i] > nums[pivot]) {
                swap(nums, pivot, i);
                break;
            }
        }

        // Reverse suffix
        reverse(nums, pivot + 1, n - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int l, int r) {
        while(l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
