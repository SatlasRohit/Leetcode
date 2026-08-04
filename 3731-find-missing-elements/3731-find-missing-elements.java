class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-1){
            if(nums[i+1]!=nums[i]+1){
                for(int j = nums[i]+1;j<nums[i+1];j++){
                    missing.add(j);
                }
            }
            i++;
        }
        return missing;
    }
}