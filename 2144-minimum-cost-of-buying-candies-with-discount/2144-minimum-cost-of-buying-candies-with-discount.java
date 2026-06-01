class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int left=0,right=n-1;
        while(left<right){
            int temp = cost[left];
            cost[left] = cost[right];
            cost[right] = temp;
            left++;
            right--;
        }
        int count=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(count == 2){
                count=0;
                continue;
            }
            sum+=cost[i];
            count++;
        }
        return sum;
    }
}