class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        for(int i=0;i<len1;i++){
            int j=0;
            while(j<len2){
                if(nums1[i] == nums2[j]) break;
                j++;
            }
            if(res[i] == 0){
                res[i] = -1;
            }
            for(int k=j;k<len2;k++){
                if(nums2[k]>nums1[i]){
                    res[i] = nums2[k];
                    break;
                }
            }
            if(res[i] == 0) res[i] = -1;
        }
        return res;
    }
}