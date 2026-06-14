class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(!((left >= 'A' && left <= 'Z') 
            ||
            (left >='a' && left <='z')
            ||
            (left >= '0' && left <= '9')
            )){
                i++;
                continue;
            }
            if(!((right >= 'A' && right <= 'Z') 
            ||
            (right >='a' && right <='z')
            ||
            (right >= '0' && right <= '9')
            )){
                j--;
                continue;
            }
            if(left >= 'A' && left <= 'Z'){
                left = (char)(left+32);
            }

            if(right >='A' && right <='Z'){
                right=(char)(right+32);
            }
            
            if(left!=right){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}