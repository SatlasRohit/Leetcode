class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        if(rev<Integer.MAX_VALUE && rev>Integer.MIN_VALUE){
            return rev;
        }
        return 0;
    }
}
