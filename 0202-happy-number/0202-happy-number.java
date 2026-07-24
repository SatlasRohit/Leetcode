class Solution {
    public boolean isHappy(int n) {
        while(n!=1 && n!=4){
            int digit = 0;
            while(n>0){
                int rem = n%10;
                n=n/10;
                digit += rem*rem;
            }
            n = digit;
        }
        return n==1;
    }
}