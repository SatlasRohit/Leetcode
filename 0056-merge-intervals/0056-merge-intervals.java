class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int i=1,j=0;
        while(i<arr.length){
            if(arr[i][0]<=arr[j][1])arr[j][1]=Math.max(arr[i][1],arr[j][1]);
            else{

                j++;
                arr[j][0]=arr[i][0];
                arr[j][1]=arr[i][1];
            } 
              i++;  
        }
        int res[][]=new int[j+1][2];
        for(i=0; i<=j; i++){
res[i][0]=arr[i][0];
res[i][1]=arr[i][1];
        }
        return res;
    }
    
}