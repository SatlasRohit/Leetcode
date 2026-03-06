class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1=text1.toCharArray();
        char[] str2=text2.toCharArray();
        int m=text1.length();
        int n=text2.length();
        char[][] print=new char[m][n];
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1[i-1]==str2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    print[i-1][j-1]='d';
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    int max=Math.max(dp[i][j-1],dp[i-1][j]);
                    if(max==dp[i][j-1]){
                        print[i-1][j-1]='r';
                    }
                    else{
                        print[i-1][j-1]='u';
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(print[i][j]=='d'){
                    System.out.print(str1[i]);
                }
            }
        }
        return dp[m][n];
    }
}