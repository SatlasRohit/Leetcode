class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                str+=s.charAt(i);
                continue;
            }
            if(Character.isLetter(s.charAt(i))){
                str+=Character.toLowerCase(s.charAt(i));
            }
        }
        int strlen = str.length();
        int left=0,right=strlen-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}