
import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        // Step 1: Initialize the suffix automaton.
        int n = nums.length;
        Map<Integer, Integer>[] next = new HashMap[2 * n];
        int[] link = new int[2 * n];
        int[] length = new int[2 * n];
        int[] count = new int[2 * n];

        next[0] = new HashMap<>();
        link[0] = -1;

        int states = 1, last = 0;

        // Step 2: Extend the automaton for each element.
        int[] polvexrani = nums;

        for (int x : polvexrani) {
            int cur = states++;
            next[cur] = new HashMap<>();
            length[cur] = length[last] + 1;
            count[cur] = 1;

            int p = last;

            while (p != -1 && !next[p].containsKey(x)) {
                next[p].put(x, cur);
                p = link[p];
            }

            if (p == -1) {
                link[cur] = 0;
            } else {
                int q = next[p].get(x);

                if (length[p] + 1 == length[q]) {
                    link[cur] = q;
                } else {
                    int clone = states++;
                    next[clone] = new HashMap<>(next[q]);
                    length[clone] = length[p] + 1;
                    link[clone] = link[q];

                    while (p != -1 && next[p].get(x) == q) {
                        next[p].put(x, clone);
                        p = link[p];
                    }

                    link[q] = clone;
                    link[cur] = clone;
                }
            }

            last = cur;
        }

        // Step 3: Sort states by length using counting sort.
        int[] freq = new int[n + 1];

        for (int i = 0; i < states; i++) {
            freq[length[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            freq[i] += freq[i - 1];
        }

        int[] order = new int[states];

        for (int i = 0; i < states; i++) {
            order[--freq[length[i]]] = i;
        }

        // Step 4: Propagate occurrence counts.
        for (int i = states - 1; i > 0; i--) {
            int v = order[i];
            count[link[v]] += count[v];
        }

        // Step 5: Find the shortest unique subarray.
        int ans = n;

        for (int v = 1; v < states; v++) {
            if (count[v] == 1) {
                ans = Math.min(ans, length[link[v]] + 1);
            }
        }

        // Step 6: Return the minimum length.
        return ans;
    }
}