class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] merge = new int[m + n];
        int j = 0, k = 0;

        for (int i = 0; i < merge.length; i++) {

            if (j < m && k < n) {
                if (nums1[j] < nums2[k]) {
                    merge[i] = nums1[j++];
                } else {
                    merge[i] = nums2[k++];
                }
            } else if (k>=n) {
                merge[i] = nums1[j++];
            } else {
                merge[i] = nums2[k++];
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = merge[i];
        }
    }
}