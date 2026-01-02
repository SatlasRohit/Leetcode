class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] count=new int[100001];
        // Compare first element with others
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if(count[nums[i]]>1){
                return nums[i];
            }
        }

        // If first element is not the repeated one,
        // then the repeated element must be among the rest
        return nums[1];
    }
}
