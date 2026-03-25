class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            
            // Left → Right
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }
            top++;
            
            // Top → Bottom
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;
            
            // Right → Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Bottom → Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return spiral;
    }
}