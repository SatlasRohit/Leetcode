class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        k = k % cols;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(mat[i][j] != mat[i][(j + k) % cols]) {
                    return false;
                }
            }
        }
        return true;
    }
}