class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(isGood(i)){
                count++;
            }
        }
        return count;
    }
    public boolean isGood(int num){
        boolean changed=false;
        while(num > 0){
            int digit=num%10;
            if(digit == 3 || digit == 7 || digit == 4){
                return false;
            }
            else if(digit == 2 || digit == 6 || digit == 9 || digit ==5){
                changed = true;
            }
            num=num/10;
        }
        return changed;
    }
}