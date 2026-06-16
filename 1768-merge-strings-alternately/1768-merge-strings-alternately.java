class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        String s="";
        int i=0;
        if(len1==len2){
            while(i<len1 && i<len2){
                s+=word1.charAt(i);
                s+=word2.charAt(i);
                i++;
            }
        }
        else if(len1>len2){
            while(i<len1 && i<len2){
                s+=word1.charAt(i);
                s+=word2.charAt(i);
                i++;
            }

            for(int j=i;j<len1;j++){
                s+=word1.charAt(j);
            }
        }
        else{
            while(i<len1 && i<len2){
                s+=word1.charAt(i);
                s+=word2.charAt(i);
                i++;
            }

            for(int j=i;j<len2;j++){
                s+=word2.charAt(j);
            }
        }
        
        return s;
    }
}