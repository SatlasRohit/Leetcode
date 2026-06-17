class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '#'){
                str.append(str.toString());
            }else if(ch == '%'){
                str.reverse();
            }else if(ch == '*'){
                if(str.length() > 0){
                    str.deleteCharAt(str.length() - 1);
                }
            }else{
                str.append(ch);
            }
        }
        return str.toString();

    }
}