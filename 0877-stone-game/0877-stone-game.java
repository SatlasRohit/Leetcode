class Solution {
    public boolean stoneGame(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int alice = 0;
        int bob = 0;
        int left = 0;
        int right = n-1;
        int len = 0;
        while(len<n){
            if(len%2 == 0){
                if(piles[left]>piles[right]){
                    alice += piles[left];
                    left++;
                }
                else{
                    alice += piles[right];
                    right--;
                }
            }
            else{
                if(piles[left]>piles[right]){
                    bob += piles[left];
                    left++;
                }
                else{
                    bob += piles[right];
                    right--;
                }
            }
            len++;
        }
        System.out.println(alice);
        System.out.println(bob);
        return (alice>bob);
    }
}