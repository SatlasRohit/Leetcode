class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> disappeared=new ArrayList<Integer>();
        int len=nums.length;
        int[] num=new int[len];
        for(int i:nums){
            num[i-1]=i;
        }
        for(int i=0;i<len;i++){
            if(num[i]==0){
                disappeared.add(i+1);
            }
        }
        return disappeared;
    
    }
}