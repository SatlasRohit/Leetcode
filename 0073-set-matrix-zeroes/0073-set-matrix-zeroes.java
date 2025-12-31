class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n=matrix[0].length;
        int[][] count=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    count[i][j]+=1;
                }
            }
        }
        // for(int row=0;row<count.length;row++){
        //     for(int col=0;col<count[row].length;col++){
        //         System.out.print(count[row][col]);
        //     }
        //     System.out.println("\n");
        // }
        for(int i=0;i<m;i++){
            int len=count[i].length;
            for(int j=0;j<len;j++){
                if(count[i][j]==1){
                    for(int k=0;k<len;k++){
                        matrix[i][k]=0;
                    }
                    for(int p=0;p<m;p++){
                        matrix[p][j]=0;
                    }
                }
            }
        }
    }
}