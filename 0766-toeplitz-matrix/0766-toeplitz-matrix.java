class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int len=matrix.length-1;
        for(int i=0;i<len;i++){
            for(int j=0;j<matrix[0].length-1;j++){
                if(matrix[i][j]!=matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}