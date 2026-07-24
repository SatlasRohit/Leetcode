class Solution {
    int fibonacci(int n){
        if(n==0 || n == 1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public int fib(int n) {
        return fibonacci(n);
    }
}