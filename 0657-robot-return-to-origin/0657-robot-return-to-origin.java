class Solution {
    public boolean judgeCircle(String moves) {
        int countL=0,countR=0,countU=0,countD=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L') countL++;
            else if(moves.charAt(i)=='R') countR++;
            else if(moves.charAt(i)=='U') countU++;
            else countD++;
        }
        Boolean stmt = Math.abs(Math.abs(countU - countD) + Math.abs(countL - countR)) ==0;        
        return stmt;
    }
}