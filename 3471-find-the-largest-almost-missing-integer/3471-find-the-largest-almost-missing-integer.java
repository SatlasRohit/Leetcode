class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if(k == n){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                max = Math.max(nums[i],max);
            }
            return max;
        }
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        if(k == 1){
            int max = -1;
            int i=0;
            for(Map.Entry<Integer,Integer> hm : mpp.entrySet()){
                if(hm.getValue() == 1){
                    max = Math.max(max,hm.getKey());
                }
            }
            return max;
        }
        int res = -1;
        if(mpp.get(nums[0]) == 1){
            res = Math.max(res,nums[0]);
        }
        if(mpp.get(nums[n-1]) == 1){
            res = Math.max(res,nums[n-1]);
        }
        return res;



    }
}