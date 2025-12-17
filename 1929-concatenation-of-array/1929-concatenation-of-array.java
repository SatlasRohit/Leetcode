class Solution {
    public int[] getConcatenation(int[] nums) {
        int len=nums.length;
        int num=2*len;
        int[] arr=new int[num];
        int i=0;
        for(int j=0;j<num;j++){
            if(j<len){
                arr[j]=nums[j];
            }
            else{
                arr[j]=nums[i];
                i++;
            }
        }
        return arr;
    }
}