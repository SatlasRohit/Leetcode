class Solution {
    public String processStr(String s) {
        int n = s.length();
        String result="";

        for(int i =0 ;i<n;i++){
           char ch=s.charAt(i);
            if(ch>=97 && ch<=122){
                result+=ch;
            }
            else if(ch == '*'){
                String str="";
                for(int j=0;j<result.length()-1;j++){
                    str+=result.charAt(j);
                }
                result = str;
            }
            else if(ch == '#'){
                result+=result;
            }
            else if(ch == '%'){
                String rev="";
                for(int j=result.length()-1;j>=0;j--){
                    rev+=result.charAt(j);
                }
                result = rev;
            }
        }

        return result;
    }
}