import java.util.Arrays;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int j = 0;

        // Place arr2 elements first
        for(int i = 0; i < arr2.length; i++){
            for(int l = j; l < arr1.length; l++){
                if(arr1[l] == arr2[i]){
                    int temp = arr1[j];
                    arr1[j] = arr1[l];
                    arr1[l] = temp;
                    j++;
                }
            }
        }

        // Sort remaining elements
        Arrays.sort(arr1, j, arr1.length);

        return arr1;
    }
}
