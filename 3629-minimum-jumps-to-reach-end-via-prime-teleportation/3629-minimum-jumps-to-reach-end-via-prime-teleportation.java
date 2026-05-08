

import java.util.Arrays;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // 1. Find the maximum value to size our arrays
        int max_val = 0;
        for (int x : nums) {
            if (x > max_val) {
                max_val = x;
            }
        }

        // 2. Sieve of Eratosthenes to identify primes efficiently
        boolean[] isComposite = new boolean[max_val + 1];
        if (max_val >= 0) isComposite[0] = true;
        if (max_val >= 1) isComposite[1] = true;
        for (int p = 2; p * p <= max_val; p++) {
            if (!isComposite[p]) {
                for (int i = p * p; i <= max_val; i += p) {
                    isComposite[i] = true;
                }
            }
        }

        // 3. Group array indices by their values for O(1) traversal
        int[] head = new int[max_val + 1];
        Arrays.fill(head, -1);
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            next[i] = head[nums[i]];
            head[nums[i]] = i;
        }

        // 4. Setup BFS
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int[] q = new int[n];
        int front = 0, rear = 0;

        q[rear++] = 0;
        dist[0] = 0;

        // Prevent reusing the same prime to trigger redundant traversals
        boolean[] prime_used = new boolean[max_val + 1];

        // 5. Run BFS
        while (front < rear) {
            int u = q[front++];
            
            if (u == n - 1) return dist[u];

            // Operation 1: Adjacent Step Backward
            if (u - 1 >= 0 && dist[u - 1] == -1) {
                dist[u - 1] = dist[u] + 1;
                if (u - 1 == n - 1) return dist[u - 1]; // Early exit
                q[rear++] = u - 1;
            }

            // Operation 2: Adjacent Step Forward
            if (u + 1 < n && dist[u + 1] == -1) {
                dist[u + 1] = dist[u] + 1;
                if (u + 1 == n - 1) return dist[u + 1]; // Early exit
                q[rear++] = u + 1;
            }

            // Operation 3: Prime Teleportation
            int p = nums[u];
            if (!isComposite[p] && !prime_used[p]) {
                prime_used[p] = true;
                
                // Jump to all multiples of the active prime `p`
                for (int m = p; m <= max_val; m += p) {
                    int j = head[m];
                    while (j != -1) {
                        if (dist[j] == -1) {
                            dist[j] = dist[u] + 1;
                            if (j == n - 1) return dist[j]; // Early exit
                            q[rear++] = j;
                        }
                        j = next[j];
                    }
                    // CRITICAL: We've now visited all indices with value `m`. 
                    // Clear the head to avoid redundant loop checks from future primes.
                    head[m] = -1; 
                }
            }
        }

        return -1; // Fallback, guaranteed to never reach here due to contiguous adjacent path
    }
}