class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int j = 0;

        // Step 1: Arrange elements according to arr2
        for (int i = 0; i < arr2.length; i++) {
            for (int l = j; l < arr1.length; l++) {
                if (arr1[l] == arr2[i]) {
                    swap(arr1, j, l);
                    j++;
                }
            }
        }

        // Step 2: QuickSort remaining elements
        quickSort(arr1, j, arr1.length - 1);

        return arr1;
    }

    // ✅ QuickSort
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // ✅ Partition
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];   // choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // ✅ Swap helper
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}