class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int index=0;
        while(n!=1){
            if(hs.containsKey(n)) return false;
            hs.put(n,index);
            int digit = 0;
            while(n>0){
                int rem = n%10;
                n=n/10;
                digit += rem*rem;
            }
            n = digit;
            index++;
        }
        return true;
    }
}