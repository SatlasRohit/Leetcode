class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        long[] rowsum = new long[row];
        long[] colsum = new long[col];

        // Row sum
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                rowsum[i] += grid[i][j];
            }
        }

        // Column sum
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                colsum[i] += grid[j][i];
            }
        }

        // Row partition
        long total = 0;
        for(long x : rowsum) total += x;

        long prefix = 0;
        for(int i=0;i<row-1;i++){
            prefix += rowsum[i];
            if(prefix == total - prefix) return true;
        }

        // Column partition
        total = 0;
        for(long x : colsum) total += x;

        prefix = 0;
        for(int j=0;j<col-1;j++){
            prefix += colsum[j];
            if(prefix == total - prefix) return true;
        }

        return false;
    }
}