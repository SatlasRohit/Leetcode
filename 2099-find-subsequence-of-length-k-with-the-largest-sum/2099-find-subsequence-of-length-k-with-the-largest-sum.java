class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new int[]{nums[i], i});
        }

        // Step 2: Sort the pairs by value in descending order
        pairs.sort((a, b) -> b[0] - a[0]);

        // Step 3: Take top k elements
        List<int[]> topK = pairs.subList(0, k);

        // Step 4: Sort the top k elements by original index to preserve order
        topK.sort((a, b) -> a[1] - b[1]);

        // Step 5: Extract the values into the result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}