class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] out=new int[2*n];
        int j=0;
        for(int i=0;i<n;i++){
            out[j]=nums[i];
            out[j+=1]=nums[i+n];
            j++;
        }
        return out;
    }
}