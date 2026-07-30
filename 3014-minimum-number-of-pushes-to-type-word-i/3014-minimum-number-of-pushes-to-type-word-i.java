class Solution {
    public int minimumPushes(String word) {
        if(word.length()<8){
            return word.length();
        }
        int len = word.length();
        int i = 1;
        int count=0;
        while(len>8){
            count += 8*i;
            len -=8;
            i++;
        }
        count += len*i;
        return count;
    }
}