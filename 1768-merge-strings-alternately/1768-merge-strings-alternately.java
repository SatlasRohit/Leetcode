class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        String s="";
        int i=0,j=0;
        while(i<len1 && j<len2){
            s+=word1.charAt(i);
            s+=word2.charAt(j);
            i++;
            j++;
        }
        if(i<len1){
            for(int k=i;k<len1;k++){
                s+=word1.charAt(k);
            }
        }
        else if(j<len2){
            for(int l=j;l<len2;l++){
                s+=word2.charAt(l);
            }
        }
        return s;
    }
}