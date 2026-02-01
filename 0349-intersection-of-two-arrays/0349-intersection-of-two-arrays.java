class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==1 && nums2.length==1){
            if(nums1[0]==nums2[0]){
                return nums1;
            }
            else{
                return new int[0];
            }
        }
        HashSet<Integer> Intersection=new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1.length<=nums2.length){
            int mid=nums2.length/2;
            for(int i=0;i<nums1.length;i++){
                if(nums1[i]>=nums2[mid]){
                    for(int j=mid;j<nums2.length;j++){
                        if(nums1[i]==nums2[j]){
                            Intersection.add(nums1[i]);
                            break;
                        }
                    }
                }
                else if(nums1[i]<nums2[mid]){
                    for(int j=0;j<mid;j++){
                        if(nums1[i]==nums2[j]){
                            Intersection.add(nums1[i]);
                            break;
                        }
                    }
                }
            }
        }
        else if(nums2.length<nums1.length){
            int mid=nums1.length/2;
            for(int i=0;i<nums2.length;i++){
                if(nums2[i]>=nums1[mid]){
                    for(int j=mid;j<nums1.length;j++){
                        if(nums2[i]==nums1[j]){
                            Intersection.add(nums2[i]);
                            break;
                        }
                    }
                }
                else if(nums2[i]<nums1[mid]){
                    for(int j=0;j<mid;j++){
                        if(nums2[i]==nums1[j]){
                            Intersection.add(nums2[i]);
                            break;
                        }
                    }
                }
            }
        }
        int[] arr=new int[Intersection.size()];
        int i=0;
        for(int a:Intersection){
            arr[i]=a;
            i++;
        }
        return arr;
    }
}