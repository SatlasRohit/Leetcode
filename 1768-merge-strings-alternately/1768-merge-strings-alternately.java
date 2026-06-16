class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        String s="";
        int i=0,j=0;
        while(i<len1 || j<len2){
            if(i<len1){
                s+=word1.charAt(i);
                i++;
            }
            if(j<len2){
                s+=word2.charAt(j);
                j++;
            }
        }
        
        return s;
    }
}