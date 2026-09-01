class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0,n=x;
        while(n>0){
            rev = (rev*10)+(n%10);
            n/=10;
        }
        if(rev == x) return true;
        return false;
    }
}