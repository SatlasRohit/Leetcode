class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        for(int i = 0; i < len; i++) {
            int index = (i + nums[i]) % len;

            // handle negative index
            if(index < 0) {
                index += len;
            }

            result[i] = nums[index];
        }

        return result;
    }
}
