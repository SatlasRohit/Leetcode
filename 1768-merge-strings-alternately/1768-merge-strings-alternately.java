class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s = new StringBuilder();
        int len1=word1.length(),len2=word2.length();
        int i=0,j=0;
        while(i<len1 || j<len2){
            if(i<len1){
                s.append(word1.charAt(i));
                i++;
            }
            if(j<len2){
                s.append(word2.charAt(j));
                j++;
            }
        }
        return s.toString();
    }
}