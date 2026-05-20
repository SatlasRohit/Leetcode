class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int n = A.length;
        
        int[] freq = new int[n + 1];
        int[] result = new int[n];
        
        int common = 0;
        
        for (int i = 0; i < n; i++) {
            
            // Add element from A
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                common++;
            }
            
            // Add element from B
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                common++;
            }
            
            result[i] = common;
        }
        
        return result;
    }
}