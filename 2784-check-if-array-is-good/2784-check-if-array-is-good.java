class Solution {
    public boolean isGood(int[] nums) {
        int n=0;
        for(int num:nums){
            if(num>n) n=num;
        }
        if(nums.length!=n+1) return false;
        int[] freq=new int[n+1];
        for(int num:nums){
            if(num<1 || num>n) return false;
            freq[num]++;
        }
        for(int i=1;i<n;i++){
            if(freq[i]!=1) return false;
        }
        return freq[n]==2;
    }
}