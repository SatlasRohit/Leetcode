class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        int sum=0;
        int mul = 1;
        while(n>0){
            int digit = (n%10);
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