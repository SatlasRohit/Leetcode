class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] letter=text.split(" ");
        int count=0,len=letter.length;
        for(String s:letter){
            for(char c:s.toCharArray()){
                if(brokenLetters.contains(String.valueOf(c))){
                    count++;
                    break;
                }
            }
        }
        len=len-count;
        return len;
    }
}