class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> Intersection =new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    Intersection.add(nums1[i]);
                    break;
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