class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int[][] temp=new int[mat.length][mat[0].length];
        int matlen1=mat.length;
        int matlen2=mat[0].length;
        for(int i = 0;i < matlen1;i++){
            for(int j = 0;j < matlen2;j++){
                temp[i][j]=mat[i][j];
            }
        }
        for(int i=0;i<k;i++){
            for(int j=0;j<matlen1;j++){
                if(j%2!=0){
                    // rightshift(temp,j,matlen2);
                    int num=mat[j][matlen2-1];
                    for(int m = matlen2-1;m>0;m--){
                        mat[j][m]=mat[j][m-1];
                    }
                    mat[j][0]=num;
                }
                else{
                    // leftshift(temp,j,matlen2);
                    int num=mat[j][0];
                    for(int m=0;m<matlen2-1;m++){
                        mat[j][m]=mat[j][m+1];
                    }
                    mat[j][matlen2-1]=num;
                }
            }
        }
        for(int i=0;i<matlen1;i++){
            for(int j=0;j<matlen2;j++){
                if(mat[i][j]==temp[i][j]) continue;
                else return false;
            }
        }
        return true;
    }

    // void leftshift(int[][] mat,int j,int matlen2){
    //     int temp=mat[j][0];
    //     for(int i=0;i<matlen2-1;i++){
    //         mat[j][i]=mat[j][i+1];
    //     }
    //     mat[j][matlen2-1]=temp;
    // }

    // void rightshift(int[][] mat,int j,int matlen2){
    //     int temp=mat[j][matlen2-1];
    //     for(int i=matlen2-1;i>0;i--){
    //         mat[j][i]=mat[j][i-1];
    //     }
    //     mat[j][0]=temp;
    // }
}