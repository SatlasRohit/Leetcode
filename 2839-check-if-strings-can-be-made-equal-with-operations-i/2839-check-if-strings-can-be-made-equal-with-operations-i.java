class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();
        for(int i=0;i<4;i++){
            if(a[i]==b[i]) continue;
            if(i<2){
                char temp=a[i];
                a[i]=a[i+2];
                a[i+2]=temp;
            }
        }
        String str1=new String(a);
        String str2=new String(b);
        return str1.equals(str2);
    }
}