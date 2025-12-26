class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int val1=st.pop();
                int val2=st.pop();
                if(s.equals("+")){
                    st.push(val2+val1);
                }
                else if(s.equals("-")){
                    st.push(val2-val1);
                }
                else if(s.equals("*")){
                    st.push(val2*val1);
                }
                else{
                    st.push(val2/val1);
                }
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}