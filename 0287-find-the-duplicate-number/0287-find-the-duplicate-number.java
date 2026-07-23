class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hs.containsKey(nums[i])) return nums[i];
            hs.put(nums[i],i);
        }
        return -1;
    }
}