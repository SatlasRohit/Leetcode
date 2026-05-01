import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        int div = grid[0][0] % x;
        int[] arr = new int[n * m];
        int k = 0;

        // Step 1: Check remainder + flatten
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] % x != div){
                    return -1;
                }
                arr[k++] = grid[i][j];
            }
        }

        // Step 2: Sort
        Arrays.sort(arr);

        // Step 3: Find median
        int median = arr[arr.length / 2];

        // Step 4: Count operations
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            count += Math.abs(arr[i] - median) / x;
        }

        return count;
    }
}