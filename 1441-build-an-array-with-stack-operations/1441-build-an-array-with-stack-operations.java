class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> str=new ArrayList<String>();
        int i=1;
        for(int num:target){
            while(i<num){
                str.add("Push");
                str.add("Pop");
                i++;
            }
            str.add("Push");
            i++;
        }
        return str;
    }
}