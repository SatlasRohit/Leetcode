import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> substrings = new ArrayList<>();

        int count = 0;
        int start = 0;

        // Step 1: Split into special substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            // Found a balanced substring
            if (count == 0) {
                // Remove outer 1 and 0
                String inner = s.substring(start + 1, i);

                // Recursively optimize inner
                String optimizedInner = makeLargestSpecial(inner);

                // Rebuild substring
                substrings.add("1" + optimizedInner + "0");

                start = i + 1;
            }
        }

        // Step 2: Sort descending
        Collections.sort(substrings, Collections.reverseOrder());

        // Step 3: Join
        StringBuilder result = new StringBuilder();
        for (String sub : substrings) {
            result.append(sub);
        }

        return result.toString();
    }
}