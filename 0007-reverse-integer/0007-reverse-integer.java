class Solution {
    public int reverse(int x) {
        int flag=0;
        if(x < 0){
            x*=-1;
            flag=1;
        }
        long  rev = 0;
        while (x > 0) {
            int digit=x % 10;
            if (rev * 10 > Integer.MAX_VALUE){
                return 0;
            }
            rev = rev * 10 + digit;
            x /= 10;
        }
        if(flag==1){
            rev*=-1;
        }
        
        return (int) rev;
    }
}
