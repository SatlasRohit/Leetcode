class Solution {

    public int numberOfSpecialChars(String word) {

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        // Traverse string
        for (char ch : word.toCharArray()) {

            // lowercase
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            }

            // uppercase
            else {
                upper[ch - 'A'] = true;
            }
        }

        int count = 0;

        // Check both exist
        for (int i = 0; i < 26; i++) {

            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }
}