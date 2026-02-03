class Solution {
    public int arrangeCoins(int n) {
        long left=1,right=n,ans=0;
        while(left<=right){
            long mid=left+(right-left)/2;
            if(check(n,mid)){
                left=mid+1;
                ans=mid;
            }else{
                right=mid-1;
            }
        }
        return (int)ans;
    }
    public boolean check(int n, long m){
        return (m*(m+1)/2)<=n;
    }
    
}