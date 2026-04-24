class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL=0,countR=0,count=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                countL++;
            }
            else if(moves.charAt(i)=='R'){
                countR++;
            }
            else{
                count++;
            }
        }
        return Math.abs(countL-countR)+count;
    }
}