class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0; // left pointer
        int max = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch) + 1, i);
            }

            map.put(ch, j);

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}