class Solution {
    public boolean stoneGame(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int alice = 0;
        int bob = 0;
        for(int i=0;i<n;i++){
            if(i%2 ==0){
                bob +=piles[i];
            }
            else{
                alice +=piles[i];
            }
        }
        return (alice>bob);
    }
}