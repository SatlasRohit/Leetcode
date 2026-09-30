class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1 ; j < n - 2 ; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int m = j+1;
                int k = n-1;
                while(m<k){
                    long sum = (long)nums[i]+nums[j]+nums[m]+nums[k];
                    if(sum<target) m++;
                    else if(sum>target) k--;
                    else{
                        ArrayList<Integer> num = new ArrayList<>();
                        num.add(nums[i]);
                        num.add(nums[j]);
                        num.add(nums[m]);
                        num.add(nums[k]);
                        m++;
                        k--;
                        res.add(num);
                        while(m<k && nums[m] == nums[m-1]) m++;
                        while(m<k && nums[k] == nums[k+1]) k--;
                    }
                }
            }
        }
        return res;
    }
}