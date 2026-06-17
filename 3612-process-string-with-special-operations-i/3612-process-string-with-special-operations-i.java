class Solution {
    public String processStr(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for(int i =0 ;i<n;i++){
            char ch =s.charAt(i);
            if(ch == '*'){
                int len = result.length();
                if(len>0){
                    result.deleteCharAt(len-1);
                }
            }
            else if(ch == '#'){
                result.append(result.toString());
            }
            else if(ch == '%'){
                result.reverse();
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }
}