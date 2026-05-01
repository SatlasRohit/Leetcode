class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length , n = grid[0].length;
        int totalElements = m * n;
        int[] freq = new int[10001];
        int rem = grid[0][0] % x;
        for(int[] row : grid){
            for(int num : row){
                if(num % x != rem) return -1;
                freq[num]++;
            }
        }
        int middle = (totalElements + 1) / 2;
        int leftElementCount = 0;
        for(int i = 1 ; i < freq.length ; i++){
            if(freq[i] == 0) continue;
            leftElementCount += freq[i];
            if(leftElementCount >= middle){
                middle = i;
                break;
            }
        }
        int op = 0;
        for(int i = 0 ; i < freq.length ; i++){
            if(freq[i] == 0) continue;
            op += (Math.abs(i - middle) / x) * freq[i];
        }
        return op;
    }
}