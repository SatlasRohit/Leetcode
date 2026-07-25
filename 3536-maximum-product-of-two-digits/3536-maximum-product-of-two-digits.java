class Solution {
    public int maxProduct(int n) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        while(n > 0){
            int digit = n%10;
            n/=10;
            if(digit >= max1){
                max2 = max1;
                max1 = digit;
            }
            else if(digit >= max2 && digit < max1){
                max2 = digit;
            }
        }
        System.out.println(max1);
        System.out.println(max2);
        return max1 * max2;
    }
}