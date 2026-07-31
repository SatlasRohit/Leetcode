class Solution {
    public int minimumPushes(String word) {

        HashMap<Character, Integer> press = new HashMap<>();

        // Count frequency
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            press.put(ch, press.getOrDefault(ch, 0) + 1);
        }

        // Get frequencies
        ArrayList<Integer> freq = new ArrayList<>(press.values());

        // Sort descending
        freq.sort(Collections.reverseOrder());

        int pressingTime = 0;

        for (int i = 0; i < freq.size(); i++) {

            int pushes = (i / 8) + 1;

            pressingTime += freq.get(i) * pushes;
        }

        return pressingTime;
    }
}