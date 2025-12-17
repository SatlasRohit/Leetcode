class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101]; // because nums[i] is between 0 and 100
        int[] result = new int[nums.length];

        // Step 1: Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: Convert freq into prefix sum
        // prefix[i] = count of numbers strictly smaller than i
        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        // Step 3: Build result
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            result[i] = n == 0 ? 0 : freq[n - 1];
        }

        return result;
    }
}
