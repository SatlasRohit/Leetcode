class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==1 && nums2.length==1){
            if(nums1[0]==nums2[0]){
                return nums1;
            }
        }
        HashSet<Integer> Intersection =new HashSet<>();
        if(nums1.length<=nums2.length){
            for(int i=0;i<nums1.length;i++){
                for(int j=0;j<nums2.length;j++){
                    if(nums1[i]==nums2[j]){
                        Intersection.add(nums1[i]);
                        break;
                    }
                }
            }
        }
        else if(nums2.length<nums1.length){
            for(int i=0;i<nums2.length;i++){
                for(int j=0;j<nums1.length;j++){
                    if(nums2[i]==nums1[j]){
                        Intersection.add(nums2[i]);
                        break;
                    }
                }
            }
        }
        
        int[] intersect=new int[Intersection.size()];
        int index=0;
        for(int val:Intersection){
            intersect[index]=val;
            index++;
        }
        return intersect;
    }
}