class Solution {
    public boolean judgeCircle(String moves) {
        int[] array = new int[26];
        for (char c : moves.toCharArray()) {
            array[c - 'A']++;
        }
        return (array['U' - 'A'] == array['D' - 'A']) && (array['L' - 'A'] == array['R' - 'A']);
    }
}