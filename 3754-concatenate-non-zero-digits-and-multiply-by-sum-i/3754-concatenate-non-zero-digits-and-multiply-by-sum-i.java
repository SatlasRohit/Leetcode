class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum=0;
        long mul = 1;
        while(n>0){
            long digit = (n%10);
            if(digit>0){
                sum+=digit;
                x+=digit*mul;
                mul*=10;
            }
            n/=10;
        }
        return x*sum;
    }
}