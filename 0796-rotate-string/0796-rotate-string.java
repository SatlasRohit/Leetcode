class Solution {
    public boolean rotateString(String s, String goal) {
        String str = s+s;
        int n1=s.length(),n2=goal.length();
        if(n1!=n2) return false;
        if(str.contains(goal)){
            return true;
        }
        return false;
    }
}