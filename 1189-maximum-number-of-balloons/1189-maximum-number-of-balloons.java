class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        
        // Count frequencies of the required characters
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }
        
        // 'l' and 'o' are needed twice per word, so divide their counts by 2
        l = l / 2;
        o = o / 2;
        
        // The answer is the limiting factor among all required letters
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}