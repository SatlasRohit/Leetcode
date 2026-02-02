class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] freq = new int[1001];

        // count frequency of nums1
        for (int x : nums1) {
            freq[x]++;
        }

        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        // collect intersection using nums2
        for (int x : nums2) {
            if (freq[x] > 0) {
                temp[k++] = x;
                freq[x]--;
            }
        }

        // copy exact result size
        int[] res = new int[k];
        System.arraycopy(temp, 0, res, 0, k);

        return res;
    }
}