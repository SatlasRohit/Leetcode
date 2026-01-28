class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<2){
            return 1;
        }
        int num=nums[0];
        // int count=0;
        int i=0;
        while(i<len-1){
            if(num==nums[i+1]){   
                for(int j=i;j<len-1;j++){
                    nums[j]=nums[j+1];
                }
                nums[len-1]=0;
                len--;
            }
            else{
                i++;
                num=nums[i];
            }
        }
        return len;
    }
}