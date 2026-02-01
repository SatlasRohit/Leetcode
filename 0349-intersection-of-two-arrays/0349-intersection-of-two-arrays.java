class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> Intersection =new HashSet<>();
        for(int arr1:nums1){
            for(int arr2:nums2){
                if(arr1==arr2){
                    Intersection.add(arr1);
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