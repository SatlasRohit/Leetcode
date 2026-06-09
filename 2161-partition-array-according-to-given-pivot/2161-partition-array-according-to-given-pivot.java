class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < n; i++) {

            if (nums[i] < pivot) {
                res[left++] = nums[i];
            }

            if (nums[n - 1 - i] > pivot) {
                res[right--] = nums[n - 1 - i];
            }
        }

        while (left <= right) {
            res[left++] = pivot;
        }

        return res;
    }
}