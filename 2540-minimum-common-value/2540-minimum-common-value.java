class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int min=Integer.MAX_VALUE;
        HashSet<Integer> hash=new HashSet<>();
        for(int num:nums1){
            hash.add(num);
        }
        for(int i=0;i<nums2.length;i++){
            if(hash.contains(nums2[i])){
                if(nums2[i]<min) min=nums2[i];
            }
        }
        return (min!=Integer.MAX_VALUE)?min:-1;
    }
}