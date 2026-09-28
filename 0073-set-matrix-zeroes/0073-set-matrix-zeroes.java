class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] count = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0) count[i][j] = 1;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(count[i][j] == 1){
                    for(int k=0;k<row;k++){
                        matrix[k][j] = 0;
                    }
                    for(int k=0;k<col;k++){
                        matrix[i][k] = 0;
                    }
                }
            }
        }
    }
}