class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for(int i=0;i<n;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int[] arr = new int[max+1];
        for(int i : nums){
            arr[i]++;
        }
        for(int i=min;i<max+1;i++){
            if(arr[i] == 0){
                missing.add(i);
            }
        }
        return missing;
    }
}