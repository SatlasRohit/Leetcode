class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        boolean[] seen=new boolean[1001];
        for(int a:nums2){
            seen[a]=true;
        }
        int[] temp=new int[Math.max(nums1.length,nums2.length)];
        int k=0;
        for(int a:nums1){
            if(seen[a]){
                temp[k++]=a;
            }
        }
        int[] intersect=new int[k];
        System.arraycopy(temp,0,intersect,0,k);
        return intersect;
    }
}