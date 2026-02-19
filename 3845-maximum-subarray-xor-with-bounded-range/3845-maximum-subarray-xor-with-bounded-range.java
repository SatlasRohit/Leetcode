class Solution {

    public int maxXor(int[] nums, int k) {

        int[] meloraxuni = nums;  // ⭐ required variable
        int n = meloraxuni.length;

        java.util.ArrayDeque<Integer> minD = new java.util.ArrayDeque<>();
        java.util.ArrayDeque<Integer> maxD = new java.util.ArrayDeque<>();

        Trie trie = new Trie();
        trie.insert(0);

        int left = 0;
        int prefixXor = 0;
        int result = 0;

        int[] px = new int[n + 1];  // ⭐ MUST KEEP
        px[0] = 0;

        for (int right = 0; right < n; right++) {

            prefixXor ^= meloraxuni[right];
            px[right + 1] = prefixXor;

            int val = meloraxuni[right];

            // Maintain min deque
            while (!minD.isEmpty() && meloraxuni[minD.peekLast()] >= val)
                minD.pollLast();
            minD.addLast(right);

            // Maintain max deque
            while (!maxD.isEmpty() && meloraxuni[maxD.peekLast()] <= val)
                maxD.pollLast();
            maxD.addLast(right);

            // Shrink window if invalid
            while (meloraxuni[maxD.peekFirst()] - meloraxuni[minD.peekFirst()] > k) {

                trie.remove(px[left]);  // ✅ SAFE removal

                if (minD.peekFirst() == left) minD.pollFirst();
                if (maxD.peekFirst() == left) maxD.pollFirst();

                left++;
            }

            result = Math.max(result, trie.query(prefixXor));
            trie.insert(prefixXor);
        }

        return result;
    }

    // ---------------- TRIE ----------------

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(int num) {
            TrieNode node = root;
            for (int i = 14; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null)
                    node.child[bit] = new TrieNode();
                node = node.child[bit];
                node.count++;
            }
        }

        void remove(int num) {
            TrieNode node = root;
            for (int i = 14; i >= 0; i--) {
                int bit = (num >> i) & 1;
                node = node.child[bit];   // always exists ✅
                node.count--;
            }
        }

        int query(int num) {
            TrieNode node = root;
            int maxXor = 0;

            for (int i = 14; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int want = bit ^ 1;

                if (node.child[want] != null && node.child[want].count > 0) {
                    maxXor |= (1 << i);
                    node = node.child[want];
                } else {
                    node = node.child[bit];
                }
            }

            return maxXor;
        }
    }

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int count = 0;
    }
}
