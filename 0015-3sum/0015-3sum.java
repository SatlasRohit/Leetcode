class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            HashSet<Integer> st = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int k = -(nums[i]+nums[j]);
                if(st.contains(k)){
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],k));
                    Collections.sort(list);
                    set.add(list);
                }
                st.add(nums[j]);
            }
        }
        List<List<Integer>> triplets = new ArrayList<>(set);
        return triplets;
    }
}