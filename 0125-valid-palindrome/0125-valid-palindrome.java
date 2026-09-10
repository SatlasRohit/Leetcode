class Solution {
    public boolean isPalindrome(String s) {
        return Check(s,0,s.length()-1);
    }
    public boolean Check(String s,int left,int right){
        if(left>=right) return true;
        if(!Character.isLetterOrDigit(s.charAt(left))) return Check(s,left+1,right);
        else if(!Character.isLetterOrDigit(s.charAt(right))) return Check(s,left,right-1);
        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
        return Check(s,left+1,right-1);
    }
}