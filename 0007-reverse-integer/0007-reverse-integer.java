class Solution {
    public int reverse(int x) {
        long  num=x;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        long rev=0;
        while(x!=0){
            rev=rev*10;
            long digit=x%10;
            rev+=digit;
            x/=10;
            if(rev>=max || rev<=min){
                return 0;
            }
        }
        return (x>0)?-(int)rev:(int)rev;
    }
}