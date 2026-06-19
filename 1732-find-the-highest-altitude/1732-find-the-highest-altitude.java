class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] trip = new int[n+1];
        trip[0]=0;
        int max = 0;
        for(int i=1;i<n+1;i++){
            trip[i]=(trip[i-1]+gain[i-1]);
            max = Math.max(max,trip[i]);
        }
        return max;
    }
}