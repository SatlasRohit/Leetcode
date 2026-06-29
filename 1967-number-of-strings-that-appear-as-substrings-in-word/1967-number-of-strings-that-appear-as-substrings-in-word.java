class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n = patterns.length;
        int count =0;
        for(int i=0;i<n;i++){
            if(word.contains(patterns[i])){
                count++;
            }
        }
        return count;
    }
}