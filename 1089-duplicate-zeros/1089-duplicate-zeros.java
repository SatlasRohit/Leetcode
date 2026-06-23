class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length;

        // Count the number of zeros
        for (int num : arr) {
            if (num == 0) {
                zeros++;
            }
        }

        int i = n - 1;
        int j = n + zeros - 1;

        // Fill from the end
        while (i >= 0) {

            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;

                if (j < n) {
                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }
    }
}