class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                char ch = word1.charAt(i);
                builder.append(ch);
                i++;
            }

            if (j < word2.length()) {
                char ch = word2.charAt(j);
                builder.append(ch);
                j++;
            }
        }
        return builder.toString();
    }
}