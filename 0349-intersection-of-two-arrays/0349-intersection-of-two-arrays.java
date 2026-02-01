class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        boolean[] seen = new boolean[1001];

        // mark nums1 values
        for (int x : nums1) {
            seen[x] = true;
        }

        // collect result (max size = min of arrays)
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        for (int x : nums2) {
            if (seen[x]) {
                temp[k++] = x;
                seen[x] = false; // avoid duplicates
            }
        }

        // copy exact size result
        int[] res = new int[k];
        System.arraycopy(temp, 0, res, 0, k);

        return res;
    }
}
