class Solution {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String ch:tokens){
            if(isOperator(ch)){
                int a=st.pop();
                int b=st.pop();
                switch(ch){
                    case "+":
                        st.push(b+a);
                        break;
                    case "-":
                        st.push(b-a);
                        break;
                    case "*":
                        st.push(b*a);
                        break;
                    case "/":
                        st.push(b/a);
                        break;
                }
            }
            else{
                 st.push(Integer.parseInt(ch));   
            }
        }
        return st.pop();
    }
    public boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}