class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        var count=0;
        while(list.size()>1){
            var Ascending=true;
            var minnum=Integer.MAX_VALUE;
            var target=-1;
            for(int i=0;i<list.size()-1;i++){
                int sum=list.get(i)+list.get(i+1);
                if(list.get(i)>list.get(i+1)){
                    Ascending=false;
                }
                if(sum<minnum){
                    minnum=sum;
                    target=i;
                }
            }
            if(Ascending){
                break;
            }
            count++;
            list.set(target,minnum);
            list.remove(target+1);
        }
        return count;
        
    }
}