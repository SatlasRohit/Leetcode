import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // Step 1: Store elements of nums1 in a HashSet
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Step 2: Find common elements using another HashSet
        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num); // ensures uniqueness
            }
        }

        // Step 3: Convert result HashSet to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}
