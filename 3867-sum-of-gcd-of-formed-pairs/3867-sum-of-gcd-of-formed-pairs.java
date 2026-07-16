class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mxi=nums[0];
        for(int k=0;k<n;k++){
            mxi = Math.max(mxi,nums[k]);
            prefixGcd[k] = Gcd(nums[k],mxi);
        }
        Arrays.sort(prefixGcd);
        long sum = 0;
        int i=0,j=n-1;
        while(i<j){
            sum+=Gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }
    public int Gcd(int a,int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}