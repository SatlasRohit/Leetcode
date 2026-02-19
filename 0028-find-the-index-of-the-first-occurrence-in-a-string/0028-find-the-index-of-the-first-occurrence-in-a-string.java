class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;

        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            int k = 0;

            while (k < needle.length() &&
                   haystack.charAt(i + k) == needle.charAt(k)) {
                k++;
            }

            if (k == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
